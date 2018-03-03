package app.module.dao.implement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.expr.BooleanExpression;

import app.module.controller.query.WebItemSearchQuery;
import app.module.dao.ItemRepositoryCustom;
import app.module.dto.common.Page;
import app.module.dto.common.PageInformation;
import app.module.entity.ItemEntity;
import app.module.entity.QItemEntity;

/**
 * @author Bodin Srisompong
 */
@Repository
public class ItemRepositoryImpl implements ItemRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<ItemEntity> getPage(WebItemSearchQuery searchQuery) {
        PageInformation pageInformation = searchQuery.getPageInfo().getPageInformation();

        JPAQuery query = new JPAQuery(entityManager);
        QItemEntity itemEntity = QItemEntity.itemEntity;
        query.from(itemEntity);

        if (searchQuery.getKeyword() != null) {
            BooleanExpression titlePredicate = itemEntity.title.like(likePattern(searchQuery.getKeyword()));
            BooleanExpression contentPredicate = itemEntity.content.like(likePattern(searchQuery.getKeyword()));

            query.where(titlePredicate.or(contentPredicate));
        }
        if (searchQuery.getTag() != null) {
            query.where(itemEntity.tags.contains(searchQuery.getTag()));
        }

        query.limit(pageInformation.getPageSize());
        query.offset(pageInformation.getOffset());

        return Page.create(pageInformation, query.list(itemEntity));
    }

    private String likePattern(String keyword) {
        return "%" + keyword + "%";
    }
}

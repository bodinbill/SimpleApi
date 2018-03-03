package app.module.dao.implement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mysema.query.jpa.impl.JPAQuery;

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
    public Page<ItemEntity> getPage(PageInformation pageInformation) {
        JPAQuery query = new JPAQuery(entityManager);
        QItemEntity itemEntity = QItemEntity.itemEntity;
        query.from(itemEntity);

        query.limit(pageInformation.getPageSize());
        query.offset(pageInformation.getOffset());

        return Page.create(pageInformation, query.list(itemEntity));
    }
}

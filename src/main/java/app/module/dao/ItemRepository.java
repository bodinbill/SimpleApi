package app.module.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.module.entity.ItemEntity;


/**
 * @author Bodin Srisompong
 */
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}

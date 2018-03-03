package app.module.dao;

import app.module.dto.common.Page;
import app.module.dto.common.PageInformation;
import app.module.entity.ItemEntity;

/**
 * @author Bodin Srisompong
 */
public interface ItemRepositoryCustom {
    Page<ItemEntity> getPage(PageInformation pageInformation);
}

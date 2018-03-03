package app.module.controller.query;

import java.util.Date;

import app.module.entity.ItemEntity;
import lombok.Data;

/**
 * @author Bodin Srisompong
 */
@Data
public class WebItemSearchQuery {
    private WebPageInformationQuery pageInfo = new WebPageInformationQuery();
    private String keyword;
    private String tag;
}

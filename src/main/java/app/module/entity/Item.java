package app.module.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Bodin Srisompong
 */
public interface Item {
    Long getKey();

    String getTitle();

    String getImageUrl();

    String getContent();

    Date getCreateDate();

    Date getUpdatedDate();

    List<String> getTags();
}

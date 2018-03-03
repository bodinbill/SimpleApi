package app.module.controller.query;

import java.util.Date;

import app.module.entity.ItemEntity;
import lombok.Data;

/**
 * @author Bodin Srisompong
 */
@Data
public class WebItemQuery {
    private String title;
    private String imageUrl;
    private String content;

    public void fill(ItemEntity item) {
        if (title != null) {
            item.setTitle(title);
        }
        if (imageUrl != null) {
            item.setImageUrl(imageUrl);
        }
        if (content != null) {
            item.setContent(content);
        }
        item.setUpdatedDate(new Date());
    }
}

package app.module.controller.query;

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
        item.setTitle(title);
        item.setImageUrl(imageUrl);
        item.setContent(content);
    }
}

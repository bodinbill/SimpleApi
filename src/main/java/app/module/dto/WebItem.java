package app.module.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import app.module.entity.ItemEntity;
import lombok.Data;


/**
 * @author Bodin Srisompong
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebItem {
    private Long key;
    private String title;
    private String imageUrl;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+7")
    private Date createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+7")
    private Date updatedDate;

    public WebItem(ItemEntity item) {
        key = item.getKey();
        title = item.getTitle();
        imageUrl = item.getImageUrl();
        content = item.getContent();
        createDate = item.getCreateDate();
        updatedDate = item.getUpdatedDate();
    }
}

package app.module.entity.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.module.entity.Item;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author Bodin Srisompong
 */
@Data
public class ItemImpl implements Item {
    private Long key;
    private String title;
    private String imageUrl;
    private String content;
    private Date createDate;
    private Date updatedDate;
    @Setter(AccessLevel.NONE)
    private List<String> tags;

    public ItemImpl() {
        tags = new ArrayList<>();
    }
}

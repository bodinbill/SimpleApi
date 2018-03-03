package app.module.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @author Bodin Srisompong
 */
@Data
@Entity
@Table(name = "ITEM")
public class ItemEntity {
    @Id
    @GeneratedValue
    @Column(name = "ITEM_KEY")
    private Long key;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "IMG_URL")
    private String imageUrl;

    @Column(name = "CONTENT")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DT")
    @Setter(AccessLevel.NONE)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_DT")
    private Date updatedDate;

    @Setter(AccessLevel.NONE)
    @Transient
    private List<String> tags;

    public ItemEntity() {
        createDate = new Date();
        tags = new ArrayList<>();
    }
}

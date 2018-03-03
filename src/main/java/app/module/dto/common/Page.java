package app.module.dto.common;

import java.util.List;

import lombok.Getter;

/**
 * @author Bodin Srisompong
 */
public class Page<T> {
    @Getter
    private PageInformation pageInformation;
    @Getter
    private List<T> entities;

    public static <T> Page<T> create(PageInformation pageInformation, List<T> entities) {
        Page<T> page = new Page<>();
        page.pageInformation = pageInformation;
        page.entities = entities;
        return page;
    }
}

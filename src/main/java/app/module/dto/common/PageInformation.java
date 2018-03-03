package app.module.dto.common;

import lombok.Getter;

/**
 * @author Bodin Srisompong
 */
public class PageInformation {
    @Getter
    private int pageNumber;
    @Getter
    private int pageSize;

    public static PageInformation create(int pageNumber, int pageSize) {
        PageInformation pi = new PageInformation();
        pi.pageNumber = pageNumber;
        pi.pageSize = pageSize;
        return pi;
    }

    public int getOffset() {
        return (pageNumber - 1) * pageSize;
    }
}

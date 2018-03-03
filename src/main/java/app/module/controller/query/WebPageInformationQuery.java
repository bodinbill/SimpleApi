package app.module.controller.query;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import app.module.dto.common.PageInformation;
import lombok.Data;

/**
 * @author Bodin Srisompong
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebPageInformationQuery {
    public static final int DEFAULT_PAGE_NUMBER = 1;
    public static final int DEFAULT_PAGE_SIZE = 10;

    private int pageNumber = DEFAULT_PAGE_NUMBER;
    private int pageSize = DEFAULT_PAGE_SIZE;

    @JsonIgnore
    public PageInformation getPageInformation() {
        return PageInformation.create(pageNumber, pageSize);
    }
}

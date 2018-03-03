package app.module.dto.common;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Bodin Srisompong
 */
public class PageInformationTest {
    @Test
    public void testOffset() {
        PageInformation pageInformation = PageInformation.create(1, 10);
        Assert.assertThat(pageInformation.getOffset(), CoreMatchers.equalTo(0));
    }

    @Test
    public void testOffsetPage3Size5() {
        PageInformation pageInformation = PageInformation.create(3, 5);
        Assert.assertThat(pageInformation.getOffset(), CoreMatchers.equalTo(10));
    }
}
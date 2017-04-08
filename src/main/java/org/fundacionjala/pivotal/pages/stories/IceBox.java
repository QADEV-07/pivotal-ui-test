package org.fundacionjala.pivotal.pages.stories;

import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Rosario Garcia
 */
public class IceBox extends BasePage {

    @FindBy(css = ".items.panel_content")
    private WebElement iceboxSection;

    public String getIceboxSection() {
        return iceboxSection.getSize().toString();
    }
}

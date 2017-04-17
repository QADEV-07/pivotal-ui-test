package org.fundacionjala.pivotal.pages.dashboard;

import com.sun.jna.platform.win32.Advapi32Util;
import org.fundacionjala.pivotal.framework.selenium.DriverManager;
import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.accounts.Accounts;
import org.fundacionjala.pivotal.pages.setting.Setting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.fundacionjala.pivotal.framework.util.CommonMethods.clickWebElement;

/**
 * @ Mijhail Villarroel.
 */
public class ToolBar extends BasePage {

    @FindBy(css = ".tc_header_item.tc_header_logo")
    private WebElement returnDashboardLink;

    @FindBy(css = "[data-aid='navTab-settings']")
    private WebElement settingsTabLink;

    public Dashboard clickReturnDashboardLink() {
        clickWebElement(returnDashboardLink);
        return new Dashboard();
    }

    public static Accounts clickAccountlink(){
        WebDriver driver = DriverManager.getInstance().getDriver();
        WebDriverWait wait = DriverManager.getInstance().getWait();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='undefined tc_profile_dropdown'] a")));
        driver.findElement(By.cssSelector("div[class='undefined tc_profile_dropdown'] a")).click();
        driver.findElement(By.cssSelector("ul[data-aid='MenuList'] a[href='/accounts']")).click();
        return new Accounts();
    }
    public Setting clickSettingTabLink() {
        clickWebElement(settingsTabLink);
        return new Setting();
    }
}
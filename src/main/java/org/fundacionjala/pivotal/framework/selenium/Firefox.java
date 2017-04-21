package org.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class initializes the Firefox Selenium Web Driver.
 *
 * @author       Henrry Salinas
 * @version      %I%, %G%
 * @since        1.0
 */
public class Firefox implements IDriver {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        return new FirefoxDriver();
    }
}

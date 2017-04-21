package org.fundacionjala.pivotal.framework.selenium;

import org.openqa.selenium.WebDriver;

/**
 * This interface define the methods related to initialize
 * the Selenium driver according to the browser used.
 *
 * @author       Henrry Salinas
 * @version      %I%, %G%
 * @since        1.0
 */
@FunctionalInterface
public interface IDriver {

    /**
     * This method initializes the Selenium web driver
     * through the classes that implements this method.
     *
     * @return the selenium Web Driver
     */
    WebDriver initDriver();
}

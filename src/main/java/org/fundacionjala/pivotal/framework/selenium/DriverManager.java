package org.fundacionjala.pivotal.framework.selenium;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.fundacionjala.pivotal.framework.util.PropertiesInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.fundacionjala.pivotal.framework.util.Constants.IMPLICIT_WAIT_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.LOAD_PAGE_TIME;
import static org.fundacionjala.pivotal.framework.util.Constants.WAIT_TIME;

/**
 * The purpose of this class is to provide basic methods for manage the Selenium driver.
 * and initialize the logger main resources path.
 *
 * @author HenrrySalinas && Bruno Barrios.
 */
public final class DriverManager {

    private static final String SRC_MAIN_RESOURCES_LOG4J_PROPERTIES = "src/main/resources/log4j.properties";

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    /**
     * This is driver manager constructor.
     */
    private DriverManager() {
        initWebDriver();
        PropertyConfigurator.configure(SRC_MAIN_RESOURCES_LOG4J_PROPERTIES);
    }

    /**
     * This method will be used to get FriverManager instance.
     *
     * @return DriverManager instance
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * This method will initialise web driver.
     */
    private void initWebDriver() {
        driver = FactoryDriver.getDriver(PropertiesInfo.getInstance().getBrowser()).initDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(LOAD_PAGE_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, WAIT_TIME);
    }

    /**
     * This method will be used to get driver.
     *
     * @return driver.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * This method will be used to quit driver.
     */
    public void quitDriver() {
        driver.quit();
    }

    /**
     * This method will be used to get wait.
     *
     * @return wait.
     */
    public WebDriverWait getWait() {
        return wait;
    }
}

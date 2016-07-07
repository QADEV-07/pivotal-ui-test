package com.fundacionjala.pivotal.framework.selenium;

import java.util.concurrent.TimeUnit;

import com.fundacionjala.pivotal.framework.util.PropertiesInfo;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static final int WAIT_TIME = 30;

    public static final int IMPLICIT_WAIT_TIME = 15;

    public static final int LOAD_PAGE_TIME = 10;

    public static final int IMPLICIT_FAIL_WAIT_TIME = 4;

    private static DriverManager instance;

    private WebDriver driver;

    private static final String SRC_MAIN_RESOURCES_LOG4J_PROPERTIES = "src/main/resources/log4j.properties";
    private DriverManager() {
        initWebDriver();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
            PropertyConfigurator.configure(SRC_MAIN_RESOURCES_LOG4J_PROPERTIES);
        }
        return instance;
    }

    private void initWebDriver() {
        PropertiesInfo.getInstance().getUrl();
        driver = FactoryDriver.getDriver(PropertiesInfo.getInstance().getBrowser()).initDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(LOAD_PAGE_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
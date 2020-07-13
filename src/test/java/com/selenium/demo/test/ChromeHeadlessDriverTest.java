package com.selenium.demo.test;

import com.maxsoft.webdrivermanager.driver.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Project Name    : maxsoft-webdriver-manager-demo
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 7/13/2020
 * Time            : 8:25 AM
 * Description     :
 **/


public class ChromeHeadlessDriverTest {

    // Holds the WebDriver instance
    public static WebDriver driver;

    // Initialize a headless driver instance of chrome browser
    @Before
    public void initializeDriver() {
        driver = DriverFactory.getDriver(DriverFactory.HEADLESS_CHROME);
        driver.manage().window().maximize();
    }

    @Test
    public void checkBrowser() {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String runningBrowserName = cap.getBrowserName().toLowerCase();
        Assert.assertEquals(BrowserType.CHROME, runningBrowserName);
    }

    @Test
    public void checkPageTitle() {
        driver.get("http://automationpractice.com/");
        Assert.assertEquals("My Store", driver.getTitle());
    }

    // Close the chrome headless driver instance
    @After
    public void closeDriver() {
        driver.quit();
    }


}

package com.selenium.demo.test;

import com.maxsoft.webdrivermanager.driver.DriverFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    @BeforeTest
    public void initializeDriver() {
        driver = DriverFactory.getDriver(DriverFactory.HEADLESS_CHROME);
        driver.manage().window().maximize();
    }

    @Test
    public void checkBrowser() {
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String runningBrowserName = cap.getBrowserName().toLowerCase();
        Assert.assertEquals(runningBrowserName, BrowserType.CHROME);
    }

    @Test
    public void checkPageTitle() {
        driver.get("http://automationpractice.com/");
        Assert.assertEquals(driver.getTitle(), "My Store");
    }

    // Close the chrome headless driver instance
    @AfterTest
    public void closeDriver() {
        driver.quit();
    }


}

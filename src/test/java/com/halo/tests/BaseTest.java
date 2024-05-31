package com.halo.tests;

import com.halo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;

    @BeforeMethod
    public void beforeMethod() {
        basePage = new BasePage(driver);
        driver = basePage.chromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        /*if(driver != null) {
            driver.quit();
        }*/
    }
}

package com.halo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private static WebDriverWait wait;
    private final By cookieAccept = By.xpath("//button[normalize-space()='Aceptar cookies']");

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.EXPLICIT_TIMEOUT));
    }

    // Set WebDriver
    public WebDriver chromeDriver() {
        System.setProperty(GlobalVariables.CHROME_DRIVER_KEY, GlobalVariables.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        return driver;
    }

    // Launch Browser
    public void launchBrowser(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    // Find Element
    private WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void type(By locator, String inputText) {
        find(locator).sendKeys(inputText);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void clickByJs(WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", e);
    }

    public boolean isElementEnabled(By locator) {
        try {
            return find(locator).isEnabled();
        } catch (AssertionError e) {
            Assert.fail();
            return false;
        }
    }

    protected void hoverElement(By locator) {
        Actions a = new Actions(driver);
        a.moveToElement(find(locator)).perform();
    }

    protected void scrollToElement(By locator) {
        Actions a = new Actions(driver);
        a.scrollToElement(find(locator)).perform();
    }

    public void acceptCookies() {
        find(cookieAccept).click();
    }

    public void assertEqualsText(By locator, String expected) {
        try {
            Assert.assertEquals(find(locator).getText(), expected);
        } catch (AssertionError e) {
            Assert.fail();
        }
    }

}

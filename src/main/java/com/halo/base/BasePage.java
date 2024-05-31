package com.halo.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.EXPLICIT_TIMEOUT));
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
    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void type(By locator, String inputText) {
        find(locator).clear();
        find(locator).sendKeys(inputText);
    }

    protected void click(By locator) {
        elementToBeClickable(locator).click();
    }

    protected void clickByJs(WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", e);
    }

    protected void hoverElement(By locator) {
        WebElement actionElement = find(locator);
        Actions a = new Actions(driver);
        if(actionElement.isDisplayed()) a.moveToElement(actionElement).perform();
    }

    protected void scrollToElement(By locator) {
        WebElement actionElement = find(locator);
        Actions a = new Actions(driver);
        a.scrollToElement(actionElement).perform();
    }

    protected void assertEqualsText(By locator, String expected) {
        try {
            Assert.assertEquals(find(locator).getText(), expected);
        } catch (AssertionError e) {
            Assert.fail("Actual value " + find(locator).getText() + " does not match with expected value " + expected);
        }
    }

    protected void assertTextChanges(By locator, String expected) {
        wait.until(ExpectedConditions.textToBe(locator, expected));
    }

    protected void selectFromDropdown(By locator, String value) {
        WebElement selectElement = elementToBeClickable(locator);
        Select selector = new Select(selectElement);
        selector.selectByValue(value);
    }

    protected WebElement elementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void switchToIFrame(By locator) {
        WebElement iframeElement = find(locator);
        driver.switchTo().frame(iframeElement);
    }

    protected void switchToMainFrame() {
        driver.switchTo().defaultContent();
    }

}

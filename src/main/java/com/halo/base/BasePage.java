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
    private Actions actions;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.EXPLICIT_TIMEOUT));
    }

    /**
     * This method set the basic properties to ChromeDriver.
     * @return instance of ChromeDriver
     */
    public WebDriver chromeDriver() {
        System.setProperty(GlobalVariables.CHROME_DRIVER_KEY, GlobalVariables.CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();
        return driver;
    }

    /**
     * Start the browser activity with window maximized.
     * @param url specifies which web page to open
     */
    public void launchBrowser(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    // Find Element

    /**
     * Method to find an Element by Locator with a Explicit Wait.
     * @param locator Element locator used to find element on a web page.
     * @return new instance of WebElement located.
     */
    protected WebElement find(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Similar 'find' method for a List of elements by Locator with a Explicit Wait.
     * @param locator Element locator used to find elements on a web page.
     * @return new instance of WebElements list located.
     */
    protected List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * This method is used internally to see if element is Clickable.
     * @param locator Element locator used to find element on a web page.
     * @return new WebElement located based on .elementToBeClickable.
     */
    protected WebElement elementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Mehthod used to locate a text field, clear the field, and sendKeys as the criteria.
     * @param locator Element locator used to find element on a web page.
     * @param inputText String as the criteria information.
     */
    protected void type(By locator, String inputText) {
        find(locator).clear();
        find(locator).sendKeys(inputText);
    }

    /**
     * Method used to click an element located with Selenium.
     * @param locator Element locator used to find element on a web page.
     */
    protected void click(By locator) {
        elementToBeClickable(locator).click();
    }

    /**
     * Method used to click a WebElement with JavaScript Executor.
     * @param e stands for element located
     */
    protected void clickByJs(WebElement e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", e);
    }

    /**
     * Method used to perform a Hover into element locator with Actions.
     * @param locator Element locator used to find element on a web page.
     */
    protected void hoverElement(By locator) {
        WebElement actionElement = elementToBeClickable(locator);
        actions = new Actions(driver);
        actions.moveToElement(actionElement).perform();
    }

    /**
     * Method used to perform a scroll to element locator with Actions.
     * @param locator Element locator used to find element on a web page.
     */
    protected void scrollToElement(By locator) {
        WebElement actionElement = find(locator);
        actions = new Actions(driver);
        actions.scrollToElement(actionElement).perform();
    }

    /**
     * Method to assert equality of two texts
     * @param locator Element locator used to find element on a web page.
     * @param expected Expected text for validation
     */
    protected void assertEqualsText(By locator, String expected) {
        try {
            Assert.assertEquals(find(locator).getText(), expected);
        } catch (AssertionError e) {
            Assert.fail("Actual value " + find(locator).getText() + " does not match with expected value " + expected);
        }
    }

    /**
     * Method to assert the changing of an Element by text
     * @param locator Element locator used to find element on a web page.
     * @param expected Expected text for validation
     */
    protected void assertTextChanges(By locator, String expected) {
        wait.until(ExpectedConditions.textToBe(locator, expected));
    }

    /**
     * Method to choose into a Selector a element byValue.
     * @param locator Element locator used to find element on a web page.
     * @param value represents the expected value to locate the element.
     */
    protected void selectFromDropdown(By locator, String value) {
        WebElement selectElement = elementToBeClickable(locator);
        Select selector = new Select(selectElement);
        selector.selectByValue(value);
    }

    /**
     * Validator with 'find' method to Expect a Condition of visibilityOfElementLocated.
     * @param locator Element locator used to find element on a web page.
     */
    protected void pageHasLoaded(By locator) {
        find(locator);
    }

    /**
     * Method to change a specific iFrame by Locator.
     * @param locator Element locator used to find element on a web page.
     */
    protected void switchToIFrame(By locator) {
        WebElement iframeElement = find(locator);
        driver.switchTo().frame(iframeElement);
    }

    /**
     * Method to change to the Main iFrame location.
     */
    protected void switchToMainFrame() {
        driver.switchTo().defaultContent();
    }

}

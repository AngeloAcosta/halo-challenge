package com.halo.pages;

import com.halo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By cookieAccept = By.xpath("//button[normalize-space()='Aceptar cookies']");

    //NavBar
    private By categoriesDisplayed = By.linkText("Categorías");
    private By txtSearchField = By.id("cb1-edit");
    private By btnSearch = By.className("nav-search-btn");

    //Categories List
    private By ddlCategories = By.xpath("//*[@class='nav-menu-categories-link']");
    private By lstTechOption = By.xpath("//a[normalize-space()='Tecnología']");
    private By lnkConsole = By.linkText("Consolas y Videojuegos");

    //Location
    private By btnLocationTo = By.xpath("//div[contains(@class,'nav-header-plus-cp-wrapper')]");
    private By ddDepartment = By.xpath("//select[@id='stateDropdown']");
    private By ddCities = By.xpath("//select[@id='citiesDropdown']");
    private By btnacceptChanges = By.xpath("//*[@data-testid='submit-button']");
    private By iframeLocation = By.xpath("//div[@data-js='modal-iframe-content']/iframe");
    private By locationOnHomeText = By.xpath("//*[@class='nav-menu-item']//span[@class='nav-menu-link-cp']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void homePageHasLoaded() {
        elementToBeClickable(categoriesDisplayed);
    }

    public void searchForElement(String criteria) {
        type(txtSearchField,criteria);
        click(btnSearch);
    }

    public void hoverCategories() {
        hoverElement(ddlCategories);
    }

    public void selectConsoleCategory() {
        hoverElement(lstTechOption);
        click(lnkConsole);
    }

    public void changeLocation(String valueDepartment, String valueCity) throws InterruptedException {
        click(btnLocationTo);
        Thread.sleep(2000);
        switchToIFrame(iframeLocation);
        selectFromDropdown(ddDepartment, valueDepartment);
        selectFromDropdown(ddCities, valueCity);
        click(btnacceptChanges);
        switchToMainFrame();
    }

    public void validateLocationChange(String expectedText) {
        assertTextChanges(locationOnHomeText,expectedText);
        assertEqualsText(locationOnHomeText, expectedText);
    }

    public void acceptCookies() {
        find(cookieAccept).click();
    }
}

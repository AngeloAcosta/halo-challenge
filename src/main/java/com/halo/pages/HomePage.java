package com.halo.pages;

import com.halo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By txtSearchField = By.id("cb1-edit");
    private By btnSearch = By.className("nav-search-btn");

    //Categories List
    private By ddlCategories = By.xpath("//*[@class='nav-menu-categories-link']//parent::li");
    private By lstTechOption = By.xpath("//a[normalize-space()='Tecnología']");
    private By lnkConsole = By.linkText("Consolas y Videojuegos");

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
}

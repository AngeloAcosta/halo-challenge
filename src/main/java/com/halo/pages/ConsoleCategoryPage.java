package com.halo.pages;

import com.halo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConsoleCategoryPage extends BasePage {


    public ConsoleCategoryPage(WebDriver driver) {
        super(driver);
    }

    private By lstCatConsoleTitle = By.xpath("//h2[normalize-space()='Consolas y Videojuegos']");

    public void moveToTitle() {
        scrollToElement(lstCatConsoleTitle);
    }

    public void validateConsoleTitle(String titleExpected) {
        assertEqualsText(lstCatConsoleTitle, titleExpected);
    }
}

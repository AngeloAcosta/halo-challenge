package com.halo.pages;

import com.halo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UnloggedUser extends BasePage {

    private By txtOnActionWhileUnlogged = By.xpath("//div[@class='wrap']//h1");

    public UnloggedUser(WebDriver driver) {
        super(driver);
    }

    public void isUnloggedMessageDisplayed(String expectedText) {
        assertEqualsText(txtOnActionWhileUnlogged, expectedText);
    }
}

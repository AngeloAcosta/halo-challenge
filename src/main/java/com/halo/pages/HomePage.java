package com.halo.pages;

import com.halo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By cookieAccept = By.xpath("//button[normalize-space()='Aceptar cookies']");
    private By homeCarrousel = By.xpath("//*[@aria-label='novedades principales']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void homePageHasLoaded() {
        pageHasLoaded(homeCarrousel);
    }

    public void acceptCookies() {
        find(cookieAccept).click();
    }
}

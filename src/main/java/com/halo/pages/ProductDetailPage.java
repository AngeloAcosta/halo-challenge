package com.halo.pages;

import com.halo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    private By btnBuyNow = By.xpath("//*[text()='Comprar ahora']//parent::button");

    public boolean isBtnBuyNowPresent() {
        return isElementEnabled(btnBuyNow);
    }
}

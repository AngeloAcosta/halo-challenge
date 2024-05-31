package com.halo.pages;

import com.halo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    private By btnBuyNow = By.xpath("//*[text()='Comprar ahora']//parent::button");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        click(btnBuyNow);
    }
}

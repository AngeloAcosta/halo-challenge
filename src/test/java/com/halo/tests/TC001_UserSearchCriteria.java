package com.halo.tests;

import com.halo.base.GlobalVariables;
import com.halo.pages.HomePage;
import com.halo.pages.ProductDetailPage;
import com.halo.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001_UserSearchCriteria extends BaseTest {

    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductDetailPage productDetailPage;
    String criteria;
    String propertyValue = "Promocionado";
    String attributeProperty = "title";

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        criteria = "the walking dead";
    }

    @Test
    public void test() throws InterruptedException {
        basePage.launchBrowser(GlobalVariables.APP_URL);

        homePage.searchForElement(criteria);

        searchResultsPage.selectElementByIndex(1,propertyValue, attributeProperty);

        Assert.assertTrue(productDetailPage.isBtnBuyNowPresent());
    }
}

package com.halo.tests;

import com.halo.base.GlobalVariables;
import com.halo.pages.HomePage;
import com.halo.pages.ProductDetailPage;
import com.halo.pages.SearchResultsPage;
import com.halo.pages.UnloggedUser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001_UserSearchCriteria extends BaseTest {

    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductDetailPage productDetailPage;
    UnloggedUser unloggedUser;

    String criteria;
    String propertyValue;
    String attributeProperty;
    String expectedText;

    int elementOnListIndex;

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        unloggedUser = new UnloggedUser(driver);

        criteria = "the walking dead";
        propertyValue = "Promocionado";
        attributeProperty = "title";
        expectedText = "¡Hola! Para comprar, ingresa a tu cuenta";

        elementOnListIndex = 1;
    }

    @Test
    public void test() {
        basePage.launchBrowser(GlobalVariables.APP_URL);

        homePage.searchForElement(criteria);

        searchResultsPage.selectElementByIndex(elementOnListIndex,propertyValue, attributeProperty);

        productDetailPage.addToCart();

        unloggedUser.isUnloggedMessageDisplayed(expectedText);
    }
}

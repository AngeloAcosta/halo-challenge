package com.halo.tests;

import com.halo.base.GlobalVariables;
import com.halo.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC001_UserSearchCriteria extends BaseTest {

    HomePage homePage;
    NavBar navBar;
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
        navBar = new NavBar(driver);
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

        homePage.homePageHasLoaded();

        navBar.searchForElement(criteria);

        searchResultsPage.selectElementByIndex(elementOnListIndex,propertyValue, attributeProperty);

        productDetailPage.addToCart();

        unloggedUser.isUnloggedMessageDisplayed(expectedText);
    }

}

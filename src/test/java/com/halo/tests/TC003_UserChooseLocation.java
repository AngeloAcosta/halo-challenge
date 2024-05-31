package com.halo.tests;

import com.halo.base.GlobalVariables;
import com.halo.pages.HomePage;
import com.halo.pages.NavBar;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC003_UserChooseLocation extends BaseTest{

    HomePage homePage;
    NavBar navBar;
    String stateLimaValue;
    String cityValue;
    String expectedCityName;


    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage = new HomePage(driver);
        navBar = new NavBar(driver);
        stateLimaValue = "PE-LMA";
        cityValue = "UEUtTE1BTGltYQ";
        expectedCityName = "Lima";
    }

    @Test
    public void test() throws InterruptedException {
        basePage.launchBrowser(GlobalVariables.APP_URL);

        homePage.homePageHasLoaded();
        navBar.changeLocation(stateLimaValue, cityValue);
        navBar.validateLocationChange(expectedCityName);
    }
}

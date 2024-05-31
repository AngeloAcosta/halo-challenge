package com.halo.tests;

import com.halo.base.GlobalVariables;
import com.halo.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC003_UserChooseLocation extends BaseTest{

    HomePage homePage;
    String stateLimaValue;
    String cityValue;
    String expectedCityName;


    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage = new HomePage(driver);
        stateLimaValue = "PE-LMA";
        cityValue = "UEUtTE1BTGltYQ";
        expectedCityName = "Lima";
    }

    @Test
    public void test() throws InterruptedException {
        basePage.launchBrowser(GlobalVariables.APP_URL);

        homePage.homePageHasLoaded();
        homePage.changeLocation(stateLimaValue, cityValue);
        homePage.validateLocationChange(expectedCityName);
    }
}

package com.halo.tests;

import com.halo.base.GlobalVariables;
import com.halo.pages.ConsoleCategoryPage;
import com.halo.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002_User_GoToConsoleCategory extends BaseTest {

    HomePage homePage;
    ConsoleCategoryPage consoleCategoryPage;
    String expectedConsoleTitle;

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage = new HomePage(driver);
        consoleCategoryPage = new ConsoleCategoryPage(driver);
        expectedConsoleTitle = "Consolas y Videojuegos";
    }

    @Test
    public void test() {
        basePage.launchBrowser(GlobalVariables.APP_URL);
        basePage.acceptCookies();

        homePage.hoverCategories();
        homePage.selectConsoleCategory();

        consoleCategoryPage.moveToTitle();
        consoleCategoryPage.validateConsoleTitle(expectedConsoleTitle);
    }
}

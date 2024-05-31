package com.halo.tests;

import com.halo.base.GlobalVariables;
import com.halo.pages.ConsoleCategoryPage;
import com.halo.pages.HomePage;
import com.halo.pages.NavBar;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002_User_GoToConsoleCategory extends BaseTest {

    HomePage homePage;
    NavBar navBar;
    ConsoleCategoryPage consoleCategoryPage;
    String expectedConsoleTitle;

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage = new HomePage(driver);
        navBar = new NavBar(driver);
        consoleCategoryPage = new ConsoleCategoryPage(driver);
        expectedConsoleTitle = "Consolas y Videojuegos";
    }

    @Test
    public void test() {
        basePage.launchBrowser(GlobalVariables.APP_URL);

        homePage.homePageHasLoaded();
        homePage.acceptCookies();
        navBar.hoverCategories();
        navBar.selectConsoleCategory();

        consoleCategoryPage.scrollToTitle();
        consoleCategoryPage.validateConsoleTitle(expectedConsoleTitle);
    }
}

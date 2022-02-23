package com.qa.pinotpicaso.tests;

import com.qa.pinotpicaso.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @BeforeClass
    public void homePageSetup() {
        homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void homePageTitleTest() {
        String Title = homePage.getHomePageTitle();
        System.out.println("Home Page Title: " + Title);
        Assert.assertEquals(Title, Constants.HOME_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void clickMainMenu() {
        String Title;
        homePage.mainMenuClick("Session");
        Title = sessionsPage.getSessionPageTitle();
        System.out.println("Session Page Title: " + Title);
        Assert.assertEquals(Title, Constants.SESSION_PAGE_TITLE);
    }
}


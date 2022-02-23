package com.qa.pinotpicaso.tests;

import com.qa.pinotpicaso.pages.HomePage;
import com.qa.pinotpicaso.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

public class SessionBookWithUserTest extends BaseTest {
    HomePage homePage;
    String loggedInUserVal;
    String sessionName = "";
    String menuName = "";
    boolean addOn, coupon;
    String couponCode;

    @BeforeClass
    public void SessionBookWithUserTest() {
        homePage = new HomePage(driver);
        //homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void homePageTitleTest() {
        String Title = homePage.getHomePageTitle();
        System.out.println("Home Page Title: " + Title);
        Assert.assertEquals(Title, Constants.HOME_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void loginTest() {
        homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        loggedInUserVal = homePage.isUSerLoggedIn("Hitesh");
        Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
        Assert.assertEquals(loggedInUserVal, prop.getProperty("accountname").toUpperCase(Locale.ROOT));
    }

    @Test(priority = 3)
    public void loginPageTitleTest() {
        String actTitle = loginPage.getLoginPageTitle();
        System.out.println("page title: " + actTitle);
        Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 4)
    public void sessionSelection() {
        homePage.mainMenuClick("Sessions");
        menuName = homePage.getStudioList();
        sessionsPage = homePage.menuItemClick(menuName);
        sessionsPage.availableSessionsClick();
        sessionName = sessionsPage.getSessionList();
    }
}

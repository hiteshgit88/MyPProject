package com.qa.pinotpicaso.tests;

import com.qa.pinotpicaso.listeners.TestAllureListener;
import com.qa.pinotpicaso.utils.Constants;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Epic 100: Pinot and Picaso App - Login Page")
@Story("US 101: Pinot and Picaso Login features")
@Listeners(TestAllureListener.class)
public class LoginPageTest extends BaseTest {

    @Description("login Page Title Test")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1)
    public void loginPageTitleTest() {
        String actTitle = loginPage.getLoginPageTitle();
        System.out.println("page title: " + actTitle);
        Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
    }

    @Description("login Test with correct credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Test(priority = 2)
    public void loginTest() {
        homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
        Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
    }
}

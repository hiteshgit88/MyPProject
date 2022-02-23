package com.qa.pinotpicaso.pages;

import com.qa.pinotpicaso.utils.Constants;
import com.qa.pinotpicaso.utils.ElementUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // 1. declare private driver
    private WebDriver driver;
    private ElementUtil eleUtil;

    // 2. By locators - Page Objects
    By linkLogin = By.className("elementor-button-text");
    By lblLoginTitle = By.xpath("//h5[normalize-space()='Login to your account']");
    By txtUserName = By.xpath("//input[@id='user']");
    By txtPassword = By.xpath("//input[@id='password']");
    By btnLogin = By.xpath("//span[normalize-space()='Log In']");
    By loginErrorMesg = By.xpath("//ul[@role='alert']");

    // 3. page constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    // 4. Page Actions:
    @Step("getting login page title value.....")
    public String getLoginPageTitle() {
        return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
    }

    @Step("do login with username: {0} and password: {1}")
    public HomePage doLogin(String username, String password) {
        System.out.println("login with : " + username + " : " + password);
        eleUtil.doClick(linkLogin);
        eleUtil.doSendKeys(txtUserName, username);
        eleUtil.doSendKeys(txtPassword, password);
        eleUtil.doClick(btnLogin);
        return new HomePage(driver);
    }

    @Step("do login with wring username: {0} and wrong password: {1}")
    public boolean doLoginWithWrongCredentials(String username, String password) {
        System.out.println("try to login with wrong credentials: " + username + " : " + password);
        eleUtil.doSendKeys(txtUserName, username);
        eleUtil.doSendKeys(txtPassword, password);
        eleUtil.doClick(btnLogin);

        String errorMesg = eleUtil.doGetText(loginErrorMesg);
        System.out.println(errorMesg);
        if (errorMesg.contains(Constants.LOGIN_ERROR_MESSG)) {
            System.out.println("login is not done....");
            return false;
        }
        return true;
    }
}

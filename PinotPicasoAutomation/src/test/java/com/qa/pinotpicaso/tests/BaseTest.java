package com.qa.pinotpicaso.tests;

import com.qa.pinotpicaso.factory.DriverFactory;
import com.qa.pinotpicaso.pages.HomePage;
import com.qa.pinotpicaso.pages.LoginPage;
import com.qa.pinotpicaso.pages.SessionsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class BaseTest {
    DriverFactory df;
    Properties prop;
    WebDriver driver;

    HomePage homePage;
    LoginPage loginPage;
    SessionsPage sessionsPage;
    SoftAssert softAssert;

    @Parameters({"browser", "browserversion"})
    @BeforeTest
    public void setup(@Optional String browser, @Optional String browserVersion) {
        df = new DriverFactory();
        prop = df.init_prop();

        if (browser != null) {
            prop.setProperty("browser", browser);
            prop.setProperty("browserversion", browserVersion);
        }
        driver = df.init_driver(prop);
        loginPage = new LoginPage(driver);
        sessionsPage=new SessionsPage(driver);
        softAssert = new SoftAssert();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

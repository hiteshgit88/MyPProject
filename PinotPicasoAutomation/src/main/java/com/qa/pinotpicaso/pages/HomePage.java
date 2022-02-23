package com.qa.pinotpicaso.pages;

import com.qa.pinotpicaso.utils.Constants;
import com.qa.pinotpicaso.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    //Locators
    By homePageHeader = By.xpath("//a[normalize-space()='Pinot & Picasso Blue Mountains']");
    By homePageLogo = By.xpath("//img[@alt='Pinot and Picasso Logo']");
    By linkLogin = By.className("elementor-button-text");
    By boxLogin = By.xpath("//div[@class='elementor-element elementor-element-68639ac6 elementor-button-align-stretch elementor-widget elementor-widget-login']");
    By linkStudios = By.xpath("//div/section/ul/li/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public String isUSerLoggedIn(String text) {
        try {
            By loggedInUserName = By.xpath("//span[contains(text(),'" + text + "')]");
            eleUtil.waitForElementsToBeVisible(loggedInUserName, 10);
            if (eleUtil.doIsDisplayed(loggedInUserName)) {
                return eleUtil.doGetText(loggedInUserName);
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    public String getHomePageTitle() {
        return eleUtil.doGetTitle(Constants.HOME_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
    }

    public boolean isLoginLinkExist() {
        return eleUtil.doIsDisplayed(linkLogin);
    }

    public boolean isLogoExist() {
        return eleUtil.doIsDisplayed(homePageLogo);
    }

    public void mainMenuClick(String text) {
        eleUtil.doClick(By.xpath("//ul[contains(@class,'elementor-nav-menu')]//li/a[contains(text(),'" + text + "')][1]"));
        driver.navigate().to("https://www.pinotandpicasso.com.au/find-a-studio/");
    }

    public String getStudioList() {
        int rndNo;
        List<WebElement> listStudios = eleUtil.getElements(linkStudios);
        rndNo = eleUtil.getRandomeNum(listStudios.size());
        return listStudios.get(rndNo).getText();
    }

    public SessionsPage menuItemClick(String text) {
        eleUtil.doClick(By.partialLinkText(text), 10);
        return new SessionsPage(driver);
    }
}

package com.qa.pinotpicaso.pages;

import com.qa.pinotpicaso.utils.Constants;
import com.qa.pinotpicaso.utils.ElementUtil;
import com.qa.pinotpicaso.utils.GlobleData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SessionsPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    //Locators
    By linkCart = By.xpath("(//a[@id='elementor-menu-cart__toggle_button'])[1]//i");
    By linkDelCard = By.xpath("//div[@aria-expanded='true']//a[@aria-label='Remove this item']");
    By linkCartClose = By.xpath("//div[@aria-expanded='true']//div[@class='elementor-menu-cart__close-button']");
    By btnAllSessions = By.xpath("//*[@id=\"sessions\"]/div/div[1]/div[1]/ul/li[1]");
    By btnAvailableSessions = By.xpath("//li[@data-filter='.ticketsAvailable']");
    By linkSession = By.xpath("//*[@id=\"sessions\"]/div/div[1]/div[1]/ul/li[2]");
    By txtHeadTitle = By.className("tribe-events-single-event-title");
    By linksSessionList = By.xpath("//h2/a[contains(@class, 'url')]");

    public SessionsPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public String getSessionPageTitle() {
        return eleUtil.doGetTitle(Constants.SESSION_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
    }

    public SessionsPage sessionClick(String text) {
        eleUtil.doClick(By.xpath("//a[normalize-space()='" + GlobleData.toTitleCase(text.toLowerCase()) + "']"));
        return new SessionsPage(driver);
    }

    public void availableSessionsClick()
    {
        eleUtil.doClick(btnAvailableSessions);
    }

    public String getSessionList() {
        int rndNo;
        List<WebElement> listSessions = eleUtil.getElements(linksSessionList);
        rndNo = eleUtil.getRandomeNum(listSessions.size());
        return listSessions.get(rndNo).getText();
    }
}

package com.qa.pinotpicaso.pages;

import com.qa.pinotpicaso.utils.Constants;
import com.qa.pinotpicaso.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudioPage {
    private WebDriver driver;
    private ElementUtil eleUtil;

    By btnAvailableSessions = By.xpath("//li[@data-filter='.ticketsAvailable']");


    public StudioPage(WebDriver driver) {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    public String getStudioPageTitle(String text) {
        return eleUtil.doGetTitle("Paint and Sip" +  text + " | Pinot and Picasso | Book Now", Constants.DEFAULT_TIME_OUT);
    }
    public void btnAvailableSessionsClick() {
        eleUtil.clickElementWhenReady(btnAvailableSessions, 10);
    }

}

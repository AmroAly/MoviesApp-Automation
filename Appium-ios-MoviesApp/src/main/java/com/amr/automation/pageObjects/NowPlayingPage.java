package com.amr.automation.pageObjects;

import com.amr.automation.utils.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class NowPlayingPage extends IOSActions {

    public IOSDriver driver;

    public NowPlayingPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Locators
    @iOSXCUITFindBy(accessibility="Now Playing")
    private WebElement nowPlayingTab;

    @iOSXCUITFindBy(accessibility="Popular")
    private WebElement popularTab;

    @iOSXCUITFindBy(accessibility="Upcoming")
    private WebElement upcomingTab;

    @iOSXCUITFindBy(accessibility="Top Rated")
    private WebElement topRatedTab;


    public NowPlayingPage goToNowPlayingTab() {

        return this;
    }

    public void goToPopularTab() {
        popularTab.click();
    }

    public void goToUpcomingTab() {
        upcomingTab.click();
    }

    public void goToTopRatedTab() {
        topRatedTab.click();
    }

    public boolean verifyPageIsDisplayed(String pageTitle) {
        switch (pageTitle) {
            case "Popular":
                return popularTab.isSelected();
            case "Upcoming":
                return upcomingTab.isSelected();
            case "Top Rated":
                return topRatedTab.isSelected();
            default:
                return nowPlayingTab.isSelected();
        }
    }

    public void gotoPage(String tabTitle) {
        switch (tabTitle) {
            case "Popular":
                goToPopularTab();
                break;
            case "Upcoming":
                goToUpcomingTab();
                break;
            case "Top Rated":
                goToTopRatedTab();
                break;
            default:
                goToNowPlayingTab();
        }
    }
}

package com.amr.automation.pageObjects;

import com.amr.automation.utils.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends IOSActions {
    public IOSDriver driver;

    public SearchPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND label == 'Search Movie'")
    private WebElement pageTitle;


    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Search' AND name == 'Search' AND type == 'XCUIElementTypeSearchField'")
    private WebElement searchField;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText)[4]")
    private WebElement searchResultMovie;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name='Empty list']")
    private WebElement emptyList;


    public boolean searchPageIsDisplayed() {
        return pageTitle.getText().equals("Search Movie");
    }

    public void searchForMovie(String movie) {
        searchField.sendKeys(movie + "\n");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifyMovieIsPresentAsAFirstResult(String movie) {
        return searchResultMovie.getAttribute("label").equals(movie);
    }

    public boolean elementExists() {
        return emptyList.isDisplayed();
    }
}

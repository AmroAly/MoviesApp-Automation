package com.amr.automation.cucumber.stepDefinitions;

import com.amr.automation.BaseTest;
import com.amr.automation.pageObjects.NowPlayingPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.net.MalformedURLException;

public class StepDefinition extends BaseTest {

    public NowPlayingPage nowPlayingPage;

    @Given("User opened the App")
    public void user_opened_the_app() throws MalformedURLException {
        nowPlayingPage = launchApp();
    }

    @When("^User clicks on (.+)$")
    public void user_clicks_on(String tabTitle) {
        nowPlayingPage.gotoPage(tabTitle);
    }

    @Then("^(.+) page is displayed$")
    public void page_is_displayed(String tab) {
        Assert.assertTrue(nowPlayingPage.verifyPageIsDisplayed(tab));
    }

    @After
    public void cleanUp() {
        tearDown();
    }

}

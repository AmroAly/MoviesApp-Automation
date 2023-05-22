package com.amr.automation.cucumber.stepDefinitions;

import com.amr.automation.BaseTest;
import com.amr.automation.pageObjects.NowPlayingPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;

import java.net.MalformedURLException;

public class StepDefinition extends BaseTest {

    public NowPlayingPage nowPlayingPage;

    @Given("User opened the App")
    public void user_opened_the_app() throws MalformedURLException {
        nowPlayingPage = launchApp();
//        nowPlayingPage.goToPopularTab();
    }

    @After
    public void cleanUp() {
        tearDown();
    }

}

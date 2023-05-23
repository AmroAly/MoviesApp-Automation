package com.amr.automation.cucumber.stepDefinitions;

import com.amr.automation.BaseTest;
import com.amr.automation.pageObjects.NowPlayingPage;
import com.amr.automation.pageObjects.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.net.MalformedURLException;

public class StepDefinition extends BaseTest {

    public NowPlayingPage nowPlayingPage;
    public SearchPage searchPage;

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

    @When("^User landed on search page$")
    public void user_landed_on_search_page() {
        searchPage = nowPlayingPage.gotoPageSearch();
    }

    @Then("Search is displayed")
    public void search_is_displayed()  {
        Assert.assertTrue(searchPage.searchPageIsDisplayed());
    }

    @Then("^(.+) Movie is present$")
    public void movie_is_present(String movie)  {
        Assert.assertTrue(searchPage.verifyMovieIsPresentAsAFirstResult(movie));
    }

    @Then("^empty list is present$")
    public void empty_list_is_present()  {
        Assert.assertTrue(searchPage.elementExists());
    }

    @And("^Search for move (.+)$")
    public void search_for_move(String movie) {
        searchPage.searchForMovie(movie);
    }

    @When("User tab the first movie")
    public void user_tab_the_first_movie() {
        nowPlayingPage.viewFirstMovie();
    }

    /*
     * isn't implemented as the current version of app
     * doesn't support viewing a single movie in a single view
     */
    @Then("Movie is displayed in a new page")
    public void movie_is_displayed_ina_a_new_page()  {
        throw new io.cucumber.java.PendingException();
    }

    @After
    public void cleanUp() {
        tearDown();
    }

}

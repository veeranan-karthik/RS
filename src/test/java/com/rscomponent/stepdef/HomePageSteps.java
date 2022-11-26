package com.rscomponent.stepdef;

import com.rscomponent.pageobjects.HomePage;
import com.rscomponent.utilities.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePageSteps {

    BasePage basePage = new BasePage();

    private final HomePage homePage;

    public HomePageSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("^the user is on traceparts homepage$")
    public void theUserIsOnTracepartsHomepage() {
        homePage.navigateToHomePage();
    }

    @When("user enters for search word {string} and clicks the search icon")
    public void userEntersForSearchWordAndClicksTheSearchIcon(String searchTerm) {
        homePage.enterSearchTermAndHitTheSearchIcon(searchTerm);
    }
}

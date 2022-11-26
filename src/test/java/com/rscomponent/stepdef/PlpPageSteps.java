package com.rscomponent.stepdef;

import com.rscomponent.pageobjects.PlpPage;
import io.cucumber.java.en.And;

public class PlpPageSteps {

    private final PlpPage plpPage;

    public PlpPageSteps(PlpPage plpPage) {
        this.plpPage = plpPage;
    }

    @And("^user clicks on the first product in the search result$")
    public void userClicksOnTheFirstProductInTheSearchResult() {
        plpPage.selectFirstPlpProduct();
    }
}

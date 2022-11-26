package com.rscomponent.stepdef;

import com.rscomponent.pageobjects.PdpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hamcrest.MatcherAssert;

import java.util.regex.Matcher;

import static org.testng.AssertJUnit.assertTrue;


public class PdpPageSteps {

    private final PdpPage pdpPage;

    public PdpPageSteps(PdpPage pdpPage) {
        this.pdpPage = pdpPage;
    }

    @And("user should be in PDP page")
    public void userShouldBeInPDPPage() {
        assertTrue(pdpPage.isUserInPdpPage());
    }

    @Then("the product title should contain {string}")
    public void theProductTitleShouldContain(String titleText) {
        MatcherAssert.assertThat("PDP product title is not matching",
                pdpPage.getPdpProductTitle().contains("LD46"));
    }

    @Then("the product decription should contain {string}")
    public void theProductDecriptionShouldContain(String descText) {
        MatcherAssert.assertThat("PDP product title is not matching",
                pdpPage.getPdpProductDescription().contains("LD46-UL-715"));
    }

    @And("user right click on the 3D product image, hovers on {string} option and choose {string} side image")
    public void userRightClickOnTheDProductImageHoversOnOptionAndChooseSideImage(String mainMenuOption, String subMenuOption) {
        pdpPage.rightClickOnPdpProductImage();
        pdpPage.userHoversOnProductImageMainMenu(mainMenuOption);
        pdpPage.selectProductImageSubMenu(subMenuOption);
    }

    @Then("the left view of the image should be displayed")
    public void theLeftViewOfTheImageShouldBeDisplayed() {

    }
}

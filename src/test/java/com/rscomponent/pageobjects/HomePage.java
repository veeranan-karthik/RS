package com.rscomponent.pageobjects;


import com.rscomponent.utilities.BasePage;
import com.rscomponent.utilities.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage {

    private WebDriver webDriver;

    @FindBy(css = "input#searchBox")
    private WebElement searchBar;

    @FindBy(css = "button#search-button")
    private WebElement searchIcon;

    @FindBy(css = "div#didomi-popup  div[role='dialog']")
    private WebElement popUp;

    @FindBy(css = "button#didomi-notice-agree-button")
    private WebElement popUpAgree;

    TestContext testContext  = TestContext.getInstance();
    BasePage basePage;

    public HomePage(BasePage basePage) {
        this.basePage = basePage;
        webDriver = this.basePage.getWebDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 30), this);
    }

    private String url = testContext.readproperty("base.url") ;

    public void navigateToHomePage(){
        webDriver.get(url);
    }

    public void enterSearchTermAndHitTheSearchIcon(String term) {
        timeUnitWait(5);
        visibilityOf(popUp);
        clickUsingJS(popUpAgree);
        clickSearchBar();
        typeSearchTerm(term);
        clickUsingJS(searchIcon);
    }

    public void clickSearchBar() {
        clickUsingJS(searchIcon);
    }

    public void typeSearchTerm(String searchTerm) {
        waitClearAndEnterText(searchBar, searchTerm);
    }
}

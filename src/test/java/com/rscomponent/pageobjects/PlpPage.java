package com.rscomponent.pageobjects;

import com.rscomponent.utilities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PlpPage extends BasePage {

    private WebDriver webDriver;

    @FindBy(css = "div:nth-of-type(1) > .g-0.row")
    private WebElement plpFirstProductImage;

    BasePage basePage;

    public PlpPage(BasePage basePage) {
        this.basePage = basePage;
        webDriver = this.basePage.getWebDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 30), this);
    }

    public void selectFirstPlpProduct() {
        basePage.visibilityOf(plpFirstProductImage);
        basePage.clickUsingJS(plpFirstProductImage);
    }
}

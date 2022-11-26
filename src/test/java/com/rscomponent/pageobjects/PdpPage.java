package com.rscomponent.pageobjects;

import com.rscomponent.utilities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PdpPage extends BasePage {
    private WebDriver webDriver;

    @FindBy(css = "div#overview h1")
    private WebElement pdpProductTitle;

    @FindBy(css = "div#bomfields-listing  tbody > tr:nth-of-type(2) > td")
    private WebElement pdpProductDescription;

    @FindBy(css = ".viewer-container")
    private WebElement pdpProductImage;

    @FindBy(css = ".context-menu > ul > li")
    private List<WebElement> pdp3DMainContentMenu;

    @FindBy(css = "li[title='Views'] > .menu > li")
    private List<WebElement> pdp3DViewsMenu;

    @FindBy(css = ".menu > .menu-item.menu-item-selected")
    private List<WebElement> selectedImageList;

    BasePage basePage;

    public PdpPage(BasePage basePage) {
        this.basePage = basePage;
        webDriver = this.basePage.getWebDriver();
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 30), this);
    }

    public Boolean isUserInPdpPage() {
        return isElementDisplayedOrNot(pdpProductTitle);
    }

    public String getPdpProductTitle() {
        return pdpProductTitle.getAttribute("innerText");
    }

    public String getPdpProductDescription() {
        return pdpProductDescription.getAttribute("innerText");
    }

    public void rightClickOnPdpProductImage() {
        timeUnitWait(5);
        basePage.waitForVisibilityOfElement(pdpProductImage);
        basePage.rightClickOnElement(pdpProductImage);
    }

    public void userHoversOnProductImageMainMenu(String menuOption) {
        basePage.waitForVisibilityOfElements(pdp3DMainContentMenu);
        WebElement mainMenuOption = pdp3DMainContentMenu.stream()
                .filter(option -> option.getText().equalsIgnoreCase(menuOption))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Menu option not found for: " + menuOption));
        basePage.waitForVisibilityOfElement(mainMenuOption);
        basePage.hoverOnElement(mainMenuOption);
    }

    public void selectProductImageSubMenu(String menuOption) {
        basePage.waitForVisibilityOfElements(pdp3DViewsMenu);
        //basePage.waitForVisibilityOfElements(pdp3DViewsMenu);
        WebElement viewsMenuOption = pdp3DViewsMenu.stream()
                .filter(option -> option.getAttribute("innerText").equalsIgnoreCase(menuOption))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Views menu option not found for: " + menuOption));
        basePage.waitForVisibilityOfElement(viewsMenuOption);
        basePage.clickUsingJS(viewsMenuOption);
    }

    public String getSelectedImageName(String selectedOption) {
        WebElement selectedImageOption = selectedImageList.stream()
                .filter(option -> option.getAttribute("innerText").equalsIgnoreCase(selectedOption))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Selected Image option not found for: " + selectedOption));
        return selectedImageOption.getAttribute("innerText");
    }
}

package com.rscomponent.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BasePage {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(BasePage.class);

    private static long DRIVER_WAIT_TIME = 30;

    private static final Logger logger = Logger.getLogger(BasePage.class.getName());

    WebDriverWait webdriverWait;

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        this.webDriver =DriverFactory.getInstance().getDriver();
        webdriverWait = new WebDriverWait(this.webDriver, DRIVER_WAIT_TIME);
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public WebDriver getDriver() {
        return this.webDriver;
    }

    public WebElement waitForVisibilityOfElement(WebElement element) {
        LOG.info("Running : waitForVisibilityOfElement");
        return webdriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForVisibilityOfElements(List<WebElement> elements) {
        LOG.info("Running : waitForVisibilityOfElements");
        return webdriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement visibilityOf(final WebElement element) {
        LOG.info("Running : visibilityOf");
        return (new WebDriverWait(getWebDriver(), DRIVER_WAIT_TIME))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForExpectedElement(WebElement element) {
        LOG.info("Running : waitForExpectedElement");
        return waitForVisibilityOfElement(element);
    }

    public void waitClearAndEnterText(WebElement element, String textToEnter) {
        LOG.info("Running : waitClearAndEnterText");
        waitForExpectedElement(element).clear();
        waitForExpectedElement(element).sendKeys(textToEnter);
    }

    public void timeUnitWait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            return;
        }
    }

    public void clickUsingJS(WebElement element) {
        LOG.info("Running : clickUsingJS");
        if (element.isDisplayed())
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", element);
        else LOG.error(" " + element + " Element is not present");
    }

    public void clickOnWebElement(WebElement element) {
        try {
            visibilityOf(element).click();
        } catch (WebDriverException e) {
            throw new RuntimeException("Element not found on the page", e);
        }
    }

    public Boolean isElementDisplayedOrNot(WebElement element) {
        LOG.info("Running : isElementDisplayedOrNot");
        boolean displayed = false;
        try {
            if (element.isDisplayed())
                displayed = true;
        } catch (NoSuchElementException e) {
            LOG.info(e.getMessage());
            return false;
        }
        return displayed;
    }

    public void rightClickOnElement(WebElement element) {
        LOG.info("Running : rightClickOnElement");
        Actions action = new Actions(webDriver);
        action.contextClick(element).perform();
    }

    public void hoverOnElement(WebElement element) {
        LOG.info("Running : hoverOnElement");
        Actions action = new Actions(webDriver);
        action.moveToElement(element).build().perform();
    }
}

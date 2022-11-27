package com.rscomponent.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class Hooks {
    private WebDriver webDriver;
    BasePage basePage;
    private static final Logger logger = Logger.getLogger(Hooks.class.getName());

    @Before
    public void beforeScenario(Scenario scenario) {
        logger.info("###########" + scenario.getName() + " Started" + "##########");
    }

    @After
    public void afterScenario(Scenario scenario) {
       if (scenario.isFailed()) {
           byte[] screenshot = ((TakesScreenshot) basePage.getWebDriver() ).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        logger.info("###########" + scenario.getName() + " Finished with status  " + scenario.getStatus() + "##########");
    }
}

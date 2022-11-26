package com.rscomponent;

import com.rscomponent.utilities.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        plugin = { "pretty", "html:target/cucumber-html-report",
                "json:target/cucumber-report/cucumber.json"},
        strict = true,
        features ="src/test/resources/features",
        tags = {"@search"},
        glue =   {"com.rscomponent.utilities",
                "com.rscomponent.stepdef","com.rscomponent.pageobjects"})

public class RunCukesTest extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setup() {
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.getInstance().removeDriver();
    }
}

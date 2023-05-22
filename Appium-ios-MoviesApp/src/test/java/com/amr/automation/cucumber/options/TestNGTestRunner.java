package com.amr.automation.cucumber.options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/com/amr/automation/cucumber/features",
        glue = "com/amr/automation/cucumber/stepDefinitions"
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}

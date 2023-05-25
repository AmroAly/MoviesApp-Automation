package com.amr.automation.cucumber.options;

import com.amr.automation.BaseTest;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;

import java.net.MalformedURLException;


@CucumberOptions(
        features = "src/test/java/com/amr/automation/cucumber/features",
        glue = "com/amr/automation/cucumber/stepDefinitions",
        monochrome = true,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber.html"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}

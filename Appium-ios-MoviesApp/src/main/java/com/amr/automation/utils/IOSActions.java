package com.amr.automation.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions {

    public IOSDriver driver;

    public IOSActions(IOSDriver driver) {
        this.driver = driver;
    }

    // Long Press Action
    public void longPress(WebElement el) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) el).getId());
        params.put("duration", 3);

        driver.executeScript("mobile:touchAndHold", params);
    }
}

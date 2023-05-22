package com.amr.automation;

import com.amr.automation.pageObjects.NowPlayingPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public IOSDriver driver;
    public AppiumDriverLocalService service;
    public NowPlayingPage nowPlayingPage;

    //@BeforeClass
    public IOSDriver initializeDriver() throws MalformedURLException {
        service =
                new AppiumServiceBuilder().withAppiumJS(new File(System.getProperty("user.home") +
                        "/.nvm/versions/node/v18.0.0/lib/node_modules/appium/build/lib/main.js")).withIPAddress("127" +
                        ".0.0.1").usingPort(4723).build();
        service.start();
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14 Pro");
        options.setApp(System.getProperty("user.dir") + "/src/main/resources/MovieInfo.app");
        options.setPlatformVersion("16.4");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public NowPlayingPage launchApp() throws MalformedURLException {
        driver = initializeDriver();
        nowPlayingPage = new NowPlayingPage(driver);
        return nowPlayingPage;
    }


    public void tearDown() {
        // close service
        driver.quit();
        service.stop();
    }
}

package com.br.swaglabs.config;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserConfig {

    private static AndroidDriver driver;

    public static void setUp() throws MalformedURLException {
        DesiredCapabilities options = new DesiredCapabilities();
        options.setCapability("platformName", "Android");
        options.setCapability("appium:deviceName", "emulator-5554");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        options.setCapability("appium:appActivity", "com.swaglabsmobileapp.SplashActivity");
        options.setCapability("appium:app", "/Users/jeanhebert/Documents/apksParaEstudosComAppium/SauceLabs.apk");
        URL url = new URL("http://localhost:4723/");
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public static void tearDown() {
        driver.quit();
    }

    public static AndroidDriver getDriver() {
        return driver;
    }
}

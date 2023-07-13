package com.nicolasrsaraiva;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {
    public final AppiumDriver driver;

    public AppiumDriverConfig() throws MalformedURLException {
        File apk = new File("C:\\Users\\nicol\\study\\appium\\alura-appium-java\\src\\main\\resources\\alura_esporte.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        URL urlConn = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver<>(urlConn, capabilities);

    }
}

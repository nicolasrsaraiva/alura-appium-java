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
    private static AppiumDriverConfig instance;

    public static AppiumDriverConfig getInstance(){
        if (AppiumDriverConfig.instance == null) {
            AppiumDriverConfig.instance = new AppiumDriverConfig();
        }
        return AppiumDriverConfig.instance;
    }
    private AppiumDriverConfig()  {
        File apk = new File("src/main/resources/alura_esporte.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        URL urlConn = null;
        try {
            urlConn = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver = new AppiumDriver<>(urlConn, capabilities);
    }
}

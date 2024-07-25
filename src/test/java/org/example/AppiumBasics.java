package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class AppiumBasics {


    @Test
    public void appiumTest() throws InterruptedException {
        //AndroidDriver, IOSDriver to test the Application
        //we need first to create a driver depend on the App Operating System (platform)


        AppiumServiceBuilder service =new AppiumServiceBuilder().withAppiumJS("C:\\Users\\Remoo\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js");

        //We write first appium code then ->
        //The Code Sent to Appium Server then Appium server send it to ->
        //Mobile platform or Android Studio in this case.
        //First parameter is appium server HTTPCommandExecutor
        //The Second one is the Capabilities which Operating System we want to use and the device name
        AndroidDriver driver;
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Reemahemulator");
        options.setApp("\\Users\\Remoo\\IdeaProjects\\AppiumProject\\src\\test\\java\\Utilities\\ApiDemos-debug.apk");


        try {
            driver =new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
            Thread.sleep(3000);
            driver.quit();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        //Then start Automation

    }
}

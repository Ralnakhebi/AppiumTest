package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.testng.annotations.Test;

import java.io.File;
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

        //To build the Appium Service Automatically without run 'appium' command in the Administrator

        AppiumDriverLocalService service =new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Remoo\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
//                .withArgument (GeneralServerFlag.BASEPATH, "/wd/hub")
//                .withArgument (GeneralServerFlag.USE_DRIVERS, "uiautomator2")
//                .withArgument (GeneralServerFlag.SESSION_OVERRIDE)
                .withTimeout(Duration.ofSeconds(300))
                .withLogFile(new File(System.getProperty("user.dir")+"\\logFile.txt"))
                .build();
        //start appium service
        service.start();

        //We write first appium code then ->
        //The Code Sent to Appium Server then Appium server send it to ->
        //Mobile platform or Android Studio in this case.
        //First parameter is appium server HTTPCommandExecutor
        //The Second one is the Capabilities which Operating System we want to use and the device name
        AndroidDriver driver;
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Reemahemulator");
        options.setApp("C:\\Users\\Remoo\\IdeaProjects\\AppiumProject\\src\\test\\java\\Utilities\\ApiDemos-debug.apk");



        try {
            driver =new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
            //driver.g
            Thread.sleep(3000);
            //quit the session
            driver.quit();
            //stop appium service
            service.stop();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        //Then start Automation

    }
}

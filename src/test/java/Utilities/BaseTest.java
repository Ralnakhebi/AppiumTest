package Utilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void setUp(){
        //AndroidDriver, IOSDriver to test the Application
        //we need first to create a driver depend on the App Operating System (platform)

        //To build the Appium Service Automatically without run 'appium' command in the Administrator

        service =new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Remoo\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
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

        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Reemahemulator");
        options.setApp("C:\\Users\\Remoo\\IdeaProjects\\AppiumProject\\src\\test\\java\\Utilities\\ApiDemos-debug.apk");



        try {
            driver =new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }
    @AfterClass
    public void tearDown(){
        //quit the session
        driver.quit();
        //stop appium service
        service.stop();
    }
}

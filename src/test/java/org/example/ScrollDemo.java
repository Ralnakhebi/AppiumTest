package org.example;

import Utilities.BaseTest;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollDemo extends BaseTest {

    @Test
    public void scrollDemoTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElements(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

        

    }
}

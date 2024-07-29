package org.example;

import Utilities.BaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class LongPress extends BaseTest {
    @Test
    public void LongPressGesture(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        //long press javascript Code
//        driver.executeScript("mobile: longClickGesture",
//                ImmutableMap.of("elementId", ""))

    }
}

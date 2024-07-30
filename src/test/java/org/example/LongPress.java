package org.example;

import Utilities.BaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class LongPress extends BaseTest {
    @Test
    public void LongPressGesture(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

        //long press Gesture with javascript Code
        WebElement longPressButton=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)longPressButton).getId(),
                        "duration",2000));

    }
}

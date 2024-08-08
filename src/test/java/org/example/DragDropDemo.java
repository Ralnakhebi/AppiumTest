package org.example;

import Utilities.BaseTest;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

public class DragDropDemo extends BaseTest {

    @Test
    public void dragDropTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        //WebElement destination=driver.findElement();

        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) source).getId(),
                "endX", 630,
                "endY", 584
        ));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

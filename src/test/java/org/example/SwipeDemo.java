package org.example;

import Utilities.BaseTest;
import Utilities.ReusableMethods;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeDemo extends BaseTest {

    @Test
    public void SwipeDemoTest(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
        WebElement firstImage =driver.findElement(By.xpath("//android.widget.ImageView[1]"));

        //Assert that the focusability for the first image is ture
        Assert.assertEquals(firstImage.getAttribute("focusable"),"true");

        //Swipe
        ReusableMethods reusableMethods=new ReusableMethods();
        reusableMethods.swipeDemo(firstImage,driver,"left");

        //Assert that the focusability for the first image turned to false after swipe the demo
        Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),"false");

    }
}

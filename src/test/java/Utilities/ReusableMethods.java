package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ReusableMethods {

    public ReusableMethods() {
    }

    public void longPressAction(WebElement longPressButton, AndroidDriver driver){

        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)longPressButton).getId(),
                        "duration",2000));
    }
    public void scrollToText(String text,AndroidDriver driver){
        driver.findElements(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));

    }

    public void swipeDemo(WebElement element, AndroidDriver driver,String direction){
        ((JavascriptExecutor)driver).executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)element).getId()
                        ,"direction",direction
                        ,"percent",0.75
                ));

    }
}

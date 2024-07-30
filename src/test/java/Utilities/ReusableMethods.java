package Utilities;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ReusableMethods {

    public ReusableMethods() {
    }

    public void longPressAction(WebElement element, AndroidDriver driver){

        WebElement longPressButton=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement)longPressButton).getId(),
                        "duration",2000));
    }
}

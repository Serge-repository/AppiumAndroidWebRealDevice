package utils;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

import static GeneralSetup.TestBasisMobile.appiumDriver;
import static GeneralSetup.TestBasisMobile.wait;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class WaitUtils {
    public void implicitWait(){
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void mobileElementExplicitWait (MobileElement mobileElement){
        wait.until(visibilityOf(mobileElement));
    }

    public void myElementExplicitWait (MyElement myElement){
        wait.until(visibilityOfElementLocated(myElement.getBy()));
    }

    public void waitingForAlertWindow(){
        wait.until(ExpectedConditions.alertIsPresent());
    }
}

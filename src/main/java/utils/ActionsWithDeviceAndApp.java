package utils;

import GeneralSetup.TestBasisMobile;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.appmanagement.AndroidTerminateApplicationOptions;

import java.time.Duration;

import static GeneralSetup.TestBasisMobile.appiumDriver;
import static org.testng.AssertJUnit.assertTrue;

public class ActionsWithDeviceAndApp {
    public void terminateApp(Duration duration){
        appiumDriver.terminateApp(TestBasisMobile.appPackage, new AndroidTerminateApplicationOptions()
                .withTimeout(Duration.ofMillis(duration.toMillis()))); // time to wait until app terminated
    }

    public void installApp(){
        appiumDriver.installApp(TestBasisMobile.appPath, new AndroidInstallApplicationOptions()
                .withReplaceEnabled()); // allows to update apps with new versions
    }

    public void checkIfAppInstalled() {
        assertTrue(appiumDriver.isAppInstalled(TestBasisMobile.appPackage));
    }

    public void runAppInBackground() {
        appiumDriver.runAppInBackground(Duration.ofMillis(4000));
    }

    public void activateApp(String appPackage) {
        appiumDriver.activateApp(appPackage); // switch between apps
    }

    public void lockDevice(Integer seconds) {
        // lock device for some time, then unlock
        ((AndroidDriver) appiumDriver).lockDevice(Duration.ofSeconds(seconds)); // only available in AndroidDriver class
    }

    public void lockDeviceForever() {
        // lock device forever
        ((AndroidDriver) appiumDriver).lockDevice(); // only available in AndroidDriver class
        System.out.println(((AndroidDriver) appiumDriver).isDeviceLocked());
    }

    public void unlockDevice() {
        ((AndroidDriver) appiumDriver).unlockDevice(); // only available in AndroidDriver class
    }
}

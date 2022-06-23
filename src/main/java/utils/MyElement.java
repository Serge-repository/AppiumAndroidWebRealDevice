package utils;

import io.appium.java_client.MobileElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

import static GeneralSetup.TestBasisMobile.appiumDriver;

public class MyElement {
    String name;
    By locator;

    public MyElement(String name, By locator) {
        this.name = name;
        this.locator = locator;
    }

    private final Logger log = LogManager.getLogger(this);

    public MobileElement getMobileElement() {
        try {
            return appiumDriver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(name + " was not found by: " + locator.toString());
        }
    }

    public void click(){
        log.debug("Going to click " + name + " element");
        try {
            getMobileElement().click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(name + " was not found by: " + locator.toString());
        }
    }

    public By getBy() {
        return this.locator;
    }

    public List<MobileElement> findElements() {
        return appiumDriver.findElements(locator);
    }
}

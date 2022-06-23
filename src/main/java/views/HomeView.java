package views;

import GeneralSetup.DataManagement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyElement;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class HomeView extends DataManagement {

    @AndroidFindBy(accessibility = "Accessibility")
    private MobileElement accessibilityButton;
    @AndroidFindBy(id = "android:id/text1")
    private MobileElement secondElement;
    @AndroidFindBy(className = "android.widget.TextView")
    private MobileElement thirdElement;
    @AndroidFindBy(id = "android:id/text1")
    private List<MobileElement> elementList;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Accessibility\")")  // see xpath
    private MobileElement elementByUiAutomator;

    private final MyElement views = new MyElement("Views button", MobileBy.AccessibilityId("Views"));

    public HomeView(AppiumDriver<MobileElement> appiumDriver, WebDriverWait wait) {
        super(appiumDriver, wait);
    }

    public void differentSelectorsStrategies() {
        // accessibilityButton.click();
        System.out.println(appiumDriver.findElementByAccessibilityId("Accessibility").getText());

        // secondElement.click();
        System.out.println(appiumDriver.findElementById("android:id/text1").getText());

        // thirdElement.click();
        System.out.println(appiumDriver.findElementByClassName("android.widget.TextView").getText());

        // берем из Appium Inspector
        System.out.println(appiumDriver.findElementByXPath("//android.widget.TextView[@content-desc=\"Accessibility\"]").getText());

        // elementsList.get(2).click();
        System.out.println(appiumDriver.findElementsById("android:id/text1").get(2).getText());
    }

    public void selectorsUsingUiAutomator2() {
        System.out.println(elementByUiAutomator.getText());

        // see selector methods for UI automator 2 here
        // https://developer.android.com/reference/androidx/test/uiautomator/UiSelector
        MobileElement oneUiAutomatorElement = (MobileElement) ((FindsByAndroidUIAutomator) appiumDriver).findElementByAndroidUIAutomator("new UiSelector().description(\"Accessibility\")");
        System.out.println(oneUiAutomatorElement); // content-desc in Appium Inspector

        List<MobileElement> elementsByUiAutomator = (List<MobileElement>) ((FindsByAndroidUIAutomator) appiumDriver).findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")");
        System.out.println(elementsByUiAutomator.get(3).getText());

        MobileElement elementsByUiAutomator2 = (MobileElement) ((FindsByAndroidUIAutomator) appiumDriver).findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")").get(3);
        System.out.println(elementsByUiAutomator2.getText());
    }

    public void byExampleForHybridApp() {
        By hybridAppBy = MobileBy.AccessibilityId("Accessibility");
        System.out.println(appiumDriver.findElement(hybridAppBy).getText());
    }

    public void selectViewsOption() {
        views.click();
    }

    public void validateAccessibilityElementByAttribute() {
        System.out.println(getElementAttribute(accessibilityButton, "text"));
        assertEquals(getElementAttribute(accessibilityButton, "text"), "Accessibility", "Element text is not correct");
        assertFalse(accessibilityButton.isSelected(), "Button is selected already");
    }

    public void tapOnElement() {
        touchAction.tap(accessibilityButton);
    }

    public void tapOnElementByCoordinates() {
        touchAction.tapOnElementByCoordinates(accessibilityButton);
    }

    public void tapOnElementByExactCoordinates(int x, int y) {
        touchAction.tapOnElementByExactCoordinates(x, y);
    }
}

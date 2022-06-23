package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

import static GeneralSetup.TestBasisMobile.appiumDriver;

public class TouchActionClass {
    public final TouchAction touchAction = new TouchAction(appiumDriver);

    public void tap(MobileElement element) {
        touchAction.tap(ElementOption.element(element)).perform();
    }

    public void tapOnElementByCoordinates(MobileElement element) {
        touchAction.tap(PointOption.point(element.getLocation())).perform();
    }

    public void tapOnElementByExactCoordinates(int x, int y) {
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    //потом обязательно нужно отпустить - release
    // waitAction - определяем время сколько нажать и удерживать элемент
    public void pressAction(MobileElement element) {
        touchAction.press(ElementOption.element(element))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).release().perform();
    }

    // ждет приблизительно секунду автоматически
    public void longPressAction(MobileElement element) {
        touchAction.longPress(ElementOption.element(element)).release().perform();
    }

    public void scrollAction(int fromX, int fromY, int toX, int toY){
        (new TouchAction(appiumDriver))
                .press(new PointOption().withCoordinates(fromX, fromY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))) //на сколько быстрым будет свайп
                .moveTo(new PointOption().withCoordinates(toX, toY))
                .release()
                .perform();
    }

    public void scrollActionUsingElements(MobileElement elementFrom, MobileElement elementTo){
        (new TouchAction(appiumDriver))
                .press(ElementOption.element(elementFrom))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))) //на сколько быстрым будет свайп
                .moveTo(ElementOption.element(elementTo))
                .release()
                .perform();
    }
}

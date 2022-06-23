package views;

import GeneralSetup.DataManagement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.MyElement;

public class ViewsView extends DataManagement {
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"TextFields\")")
    private MobileElement textFieldOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"WebView\")")
    private MobileElement webViewOption;
    private final MyElement galleryImage = new MyElement("Gallery image", MobileBy.className("android.widget.ImageView"));
    private final MyElement animation = new MyElement("Animation", MobileBy.xpath("//.[@content-desc=\"Animation\"]"));
    private final MyElement gallery = new MyElement("Gallery", MobileBy.AccessibilityId("Gallery"));
    private final MyElement link = new MyElement("Link", MobileBy.xpath("//a"));

    public ViewsView(AppiumDriver<MobileElement> appiumDriver, WebDriverWait wait) {
        super(appiumDriver, wait);
    }

    public void selectTextFieldsOption(){
        textFieldOption.click();
    }

    public void selectWebViewOption(){
        webViewOption.click();
    }

    public void chooseLink(){
        link.click();
    }

    public void pressAction() {
        touchAction.pressAction(galleryImage.findElements().get(0));
    }

    public void longPressAction() {
        MobileElement elementToUse = galleryImage.findElements().get(1);
        touchAction.longPressAction(elementToUse);
    }

    public void scrollFromGalleryToAnimation() {
        touchAction.scrollActionUsingElements(gallery.getMobileElement(), animation.getMobileElement());
    }
}

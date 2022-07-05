package GeneralSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertiesLoader;
import views.HomeView;
import views.ViewsView;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestBasisMobile {
    public static AppiumDriver<MobileElement> appiumDriver;
    public static WebDriverWait wait;

    public DesiredCapabilities capabilities = new DesiredCapabilities();
    public URL serverAddress;
    public DeviceEnvironment deviceEnvironment;
    public PropertiesLoader propertiesLoader = new PropertiesLoader();

    public HomeView homeView;
    public ViewsView viewsView;

    public static String appPackage = "io.appium.android.apis";
    public static String appPath;

    @BeforeClass
    public void beforeClass() throws IOException {
// выбираем с чем работаем - эмулятор или реальный девайс
        chooseEnvironmentCapabilities();
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 1000);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        appPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        capabilities.setCapability(MobileCapabilityType.APP, appPath);
// сколько сохранять активность сессии в дебаге
        capabilities.setCapability("newCommandTimeout", 300);  //5 minutes
        capabilities.setCapability("appPackage", appPackage);

        if (deviceEnvironment == DeviceEnvironment.EMULATOR) {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 API 30");
            capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
// для автоматического запуска эмулятора
            capabilities.setCapability("avd", "Pixel_4_API_30");
            capabilities.setCapability("avdLaunchTimeout", 180000);  //3 minutes
// для разблокировки экрана
            capabilities.setCapability("unlockType", "pin");
            capabilities.setCapability("unlockKey", "0000");
//  capabilities.setCapability("unlockType", "pattern");
//  capabilities.setCapability("unlockKey", "125478963"); // каждая точка паттерна это определенная цифра
        } else if (deviceEnvironment == DeviceEnvironment.REAL_DEVICE) {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Xiaomi 11T");
            capabilities.setCapability(MobileCapabilityType.UDID, propertiesLoader.getRealDeviceUdidProperty("xiaomi_11_T"));
// настройка которая позволяет АВТОМАТИЧЕСКИ СКАЧИВАТЬ и запускать версию драйвера совместимую с текущим Appium
            String driverPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                    + File.separator + "java" + File.separator + "chromedriver";
            capabilities.setCapability("chromedriverExecutableDir", driverPath);
        }
        serverAddress = new URL("http://0.0.0.0:4723/wd/hub");
    }

    @AfterClass
    public void actionsAfterClass() {
        appiumDriver.quit();
    }

    private void chooseEnvironmentCapabilities() {
        if (deviceEnvironment == null) {
            deviceEnvironment = DeviceEnvironment.valueOf(System.getProperty("deviceEnvironment", "REAL_DEVICE").toUpperCase());
        }
    }

    private void initializeDriver() {
        appiumDriver = new AndroidDriver<>(serverAddress, capabilities);
        wait = new WebDriverWait(appiumDriver, 10);
        initializeClasses();
    }

    private void initializeClasses() {
        homeView = new HomeView(appiumDriver, wait);
        viewsView = new ViewsView(appiumDriver, wait);
    }

    protected void setAppActivity(AppActivities appActivity) {
        capabilities.setCapability("appActivity", appActivity.getActivityPath());
        initializeDriver();
    }
}

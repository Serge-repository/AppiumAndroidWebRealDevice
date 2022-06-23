package appium_tests;

import GeneralSetup.AppActivities;
import GeneralSetup.TestBasisMobile;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoApkTests extends TestBasisMobile {
    @BeforeMethod
    public void beforeMethod(){
        setAppActivity(AppActivities.HOME_VIEW);
    }

    @Test
    public void automateHybridWebView(){
        homeView.selectViewsOption();
        viewsView.getTouchAction().scrollAction(448, 1752, 551, 389);
        viewsView.getTouchAction().scrollAction(448, 1752, 551, 389);
        viewsView.getTouchAction().scrollAction(448, 1752, 551, 389);
        viewsView.selectWebViewOption();
        viewsView.seeAllContexts();
        viewsView.chooseContext("WEBVIEW");
        viewsView.chooseLink();
    }
}
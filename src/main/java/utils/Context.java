package utils;

import java.util.Set;

import static GeneralSetup.TestBasisMobile.appiumDriver;

public class Context {
    public void seeAllAppContexts(){
        Set<String> appContexts = appiumDriver.getContextHandles();
        for (String context : appContexts) {
            System.out.println(context);
        }
    }

    public void setAppContext(String contextName){
        appiumDriver.context(contextName);
    }
}

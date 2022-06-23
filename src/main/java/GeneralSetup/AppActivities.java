package GeneralSetup;

public enum AppActivities {
    HOME_VIEW("io.appium.android.apis.ApiDemos"),
    TEXT_FIELDS_VIEW("io.appium.android.apis.view.TextFields"),
    GALLERY_ONE_VIEW("io.appium.android.apis.view.Gallery1");

    final String activityPath;

    AppActivities(String activityPath) {
        this.activityPath = activityPath;
    }

    public String getActivityPath() {
        return activityPath;
    }
}

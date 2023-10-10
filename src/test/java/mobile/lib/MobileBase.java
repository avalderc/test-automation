package mobile.lib;

import io.appium.java_client.android.AndroidDriver;

public class MobileBase {
    protected AndroidDriver getDriver() {
        return MobileDriverManager.getDriver();
    }
}

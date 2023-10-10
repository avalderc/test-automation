package mobile.lib;

import com.environment.ManageEnvironment;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MobileDriverManager {
    private static AndroidDriver androidDriver;
    public static void setDriver(AndroidDriver androidDriver) {
        MobileDriverManager.androidDriver = androidDriver;
    }
    public static AndroidDriver getDriver() {
        return MobileDriverManager.androidDriver;
    }
    public static void setUpDriver(){
        try {
            //Capabilities
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.APP, ManageEnvironment.getProperty("user.dir")+"\\apk\\exitoApk.apk");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.exito.appcompania");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".views.initialaccess.activities.SplashActivity");
            desiredCapabilities.setCapability("appium:udid", "emulator-5554");
            desiredCapabilities.setCapability("appium:deviceName", "Pixel_3a_API_34");
            desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:version", "1.21.0");
            desiredCapabilities.setCapability("appium:newCommandTimeout", "50000");
            desiredCapabilities.setCapability("autoGrantPermissions", "true");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, "30000");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "*");
            //Appium Server
            URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");
            AndroidDriver androidDriver = new AndroidDriver(appiumServer, desiredCapabilities);
            androidDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
            System.out.println(androidDriver.getSessionId());
            setDriver( androidDriver );
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void quitDriver() {
        System.out.print("- Cerrando driver...");
        if (isDriverOn()) {
            getDriver().quit();
            System.out.println(" [OK]");
        } else
            System.out.println(" [FAIL]: La sesión del driver no existe");
    }
    private static boolean isDriverOn() {
        return getDriver() != null;
    }

}

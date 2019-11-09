package framework;

import cucumber.api.java.After;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import util.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumWrapper {

    private static AppiumDriver appiumDriver;

    /**
     * This method initializes the appium driver object on default mobile device specified in the config file
     *
     * @throws MalformedURLException
     */
    private static void intializeAppiumDriver() throws MalformedURLException {
        appiumDriver = buildAppiumDriver();

        // This is used in cases where fluent wait is not applied (fluentWait() at BaseWebPage class)
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    private static AppiumDriver buildAppiumDriver() throws MalformedURLException {
        ConfigReader configReader = new ConfigReader();
        AppiumDriver appiumDriver = null;
        String appiumServerURL = "http://0.0.0.0:4723/wd/hub";
        String platformName = configReader.getMobilePlatformName();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, configReader.getMobileAutomationName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, configReader.getMobileDeviceName());
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, configReader.getMobileAppPath());
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 190000);

        if (platformName.equals("ios")) {
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, configReader.getMobileVersion());
            appiumDriver = new IOSDriver(new URL(appiumServerURL), capabilities);
        } else if (platformName.equals("android")) {
            //Keeping this here for now incase if we need to use it some point
            capabilities.setCapability("appActivity", "com.applause.automation.ionicconference.MainActivity");
            capabilities.setCapability("appPackage", "com.applause.automation.ionicconference");
            appiumDriver = new AndroidDriver(new URL(appiumServerURL), capabilities);
        } else {
            throw new UnsupportedOperationException("Invalid Platform Name" + platformName);
        }

        return appiumDriver;
    }

    /**
     * This will start an Appium server and return an Appium driver (or initialize it if it's not initialized)
     * Only 1 driver and server will be started/initialized per run
     *
     * @return Appium driver
     */

    public static AppiumDriver getAppiumDriver() {
        if (appiumDriver == null) {
            try {
                // Initialize the appium server the first time the driver is created

                // the start appium server may be called mulitple times, since only 1 instance is created
                intializeAppiumDriver();
            } catch (MalformedURLException e) {
                Assert.fail("Unable to initialize Appium driver due to invalid Server URL or there server is already in use");

            }
        }

        return appiumDriver;
    }

    /**
     * This method is used to quit the Appium driver if it is not null
     */
    @After("@mobile")
    public static void quitAppiumDriver() {
        if (appiumDriver != null) {
            System.out.println("Quitting Appium..");
            appiumDriver.quit();
            System.out.println("Quitting Appium - Done");
            appiumDriver = null;
        }
    }
}

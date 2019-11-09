package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mohammad Muntakim
 */
public class ConfigReader {

    private String url;
   // private String getRegisterPageUrl;
    private String chromeDriverPath;
    private String mobilePlatformName;
    private String mobileAutomationName;
    private String mobileVersion;
    private String mobileDeviceName;
    private String mobileAppPath;
    private String registerPageurl;

    public ConfigReader() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.url = prop.getProperty("url");
            this.registerPageurl=prop.getProperty("register_page_url");
            this.chromeDriverPath = prop.getProperty("chrome_driver_path");
            this.mobilePlatformName = prop.getProperty("mobile_platform_name");
            this.mobileAutomationName = prop.getProperty("mobile_automation_name");
            this.mobileVersion = prop.getProperty("mobile_version");
            this.mobileAppPath = prop.getProperty("mobile_app_path");
            this.mobileDeviceName = prop.getProperty("mobile_device");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUrl() {

        return url;
    }

    public String getChromeDriverPath() {

        return chromeDriverPath;
    }

    public String getMobilePlatformName() {
        return mobilePlatformName;
    }

    public String getMobileAutomationName() {
        return mobileAutomationName;
    }

    public String getMobileVersion() {
        return mobileVersion;
    }

    public String getMobileDeviceName() {
        return mobileDeviceName;
    }

    public String getMobileAppPath() {
        return mobileAppPath;
    }


    public String getRegisterPageUrl() {
        return registerPageurl;
    }
}

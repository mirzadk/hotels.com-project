package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.ConfigReader;

public class SharedSD {

	private static WebDriver driver = null;

	@Before("@web")
	public static void before() {

		ConfigReader configReader = new ConfigReader();
		System.setProperty("webdriver.chrome.driver",
				configReader.getChromeDriverPath());
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(configReader.getUrl());
	}

	@After("@web")
	public static void after() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}
}

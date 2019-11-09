package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import stepdefinition.SharedSD;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {

	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public static String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by visible text
		selectMonth.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	/////
	public String getPageSource() {
		return SharedSD.getDriver().getPageSource();
	}
	public void scrollToElement(By locator) {
		WebElement element=webAction(locator);
		((JavascriptExecutor)SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView();", element);

	}




	////
	public boolean keyPress(String key){
		try{
			SharedSD.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			Actions act = new Actions( SharedSD.getDriver());
			Thread.sleep(2000);

			switch(key){
				case "DOWN":
					act.sendKeys(Keys.DOWN).perform();
					Thread.sleep(2000);
					break;
				case "ENTER":
					act.sendKeys(Keys.ENTER).perform();
					Thread.sleep(2000);
					break;
				case "UP":
					act.sendKeys(Keys.UP).perform();
					break;
				default:
					throw new IllegalStateException("Unexpected value: " + key);
			}

		}catch(Exception e){
			return false;
		}
		return true;
	}



	public boolean waitForElementvisible(WebElement element,int timeOutInSsec ){
		try{

			SharedSD.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = null;
			wait=new WebDriverWait(SharedSD.getDriver(), timeOutInSsec);
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e){
			SharedSD.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			return false;
		}
		SharedSD.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		return true;
	}
}


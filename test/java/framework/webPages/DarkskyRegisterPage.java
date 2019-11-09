package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import stepdefinition.SharedSD;
import util.ConfigReader;

public class DarkskyRegisterPage extends BasePage{

    private By registerButton = By.xpath("//button[contains(text(),'Register')]");

    ConfigReader configReader=new ConfigReader();

    public String getPageSource() {
        return SharedSD.getDriver().getPageSource();
    }

    public void navigateToSignUpPage() {
        SharedSD.getDriver().get(configReader.getRegisterPageUrl());
    }

    public void clickOnRegisterButton() {
        clickOn(registerButton);
    }

    public String getValidationText() {
        JavascriptExecutor js =(JavascriptExecutor)SharedSD.getDriver();
        return js.executeScript("return document.getElementsByTagName('INPUT')[1].validationMessage;").toString();
    }


}

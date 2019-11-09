package framework.webPages;

import org.openqa.selenium.By;

public class MessengerPage extends BasePage{

    private By emailField = By.id("");
    private By passwordField = By.id("");
    private By signUpButton = By.id("");

    public void enterEmail(String email) {
        setValue(emailField, email);
    }

    public void enterPassword(String password) {
        setValue(passwordField, password);
    }

    public void clickOnSignupButton() {
        clickOn(signUpButton);
    }
}

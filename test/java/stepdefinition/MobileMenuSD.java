package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.mobilePages.HomeScreen;
import framework.mobilePages.MainMenu;
import org.testng.Assert;

public class MobileMenuSD {

    private MainMenu mainMenu = new MainMenu();
    private HomeScreen homeScreen = new HomeScreen();

    @When("^I tap on skip button")
    public void clickOnSkipButton() {
        homeScreen.tapOnSkipButton();
    }

    @When("^I tap on menu button$")
    public void clickOnMenuButton() throws InterruptedException {
        Thread.sleep(30000);
        homeScreen.tapOnMainMenuButton();
    }

    @Then("^I verify sidebar menu is displayed$")
    public void verifySidebarMenu() {
        Assert.assertTrue(mainMenu.isMenuPresent());
    }
}

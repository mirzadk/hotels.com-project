package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkskyRegisterPage;
import org.junit.Assert;

public class DarkSkySignUpSD {

    private DarkskyRegisterPage signupPage = new DarkskyRegisterPage();

    @Given("^I am on the Darksky register page$")
    public void iAmOnTheDarkskyRegisterPage(){
        signupPage.navigateToSignUpPage();
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"Dark Sky API: Register");
    }

    @When("^I click on Register button$")
    public void iClickOnRegisterButton() throws Throwable {
        signupPage.clickOnRegisterButton();

    }

    @Then ("^I verify error message \"([^\"]*)\"$")
    public void iVerifyErrorMessage(String arg1) throws Throwable {

        String validationText=signupPage.getValidationText();
        Assert.assertEquals(validationText, arg1);

    }

}

package stepdefinition;

import cucumber.api.java.en.Then;
import framework.webPages.HomePage;
import org.junit.Assert;

public class SignupSD {

    private HomePage homePage = new HomePage();

    @Then("^I verify gender (female|male) is selected$")
    public void genderValidation(String gender) {

        if (gender.equals("female")) {
            if (!homePage.isGenderFemaleSelected()) {
                homePage.clickOnFemaleGender();
            }
            Assert.assertTrue(homePage.isGenderFemaleSelected());
        } else if (gender.equals("male")) {
            if (!homePage.isGenderMaleSelected()) {
                homePage.clickOnMaleGender();
            }
            Assert.assertTrue(homePage.isGenderMaleSelected());
        }
    }

}

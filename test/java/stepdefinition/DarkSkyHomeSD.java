package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.DarkskyHomePage;
import framework.webPages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DarkSkyHomeSD {
    private DarkskyHomePage DarkHomePage = new DarkskyHomePage();

    //#1
    @Given("^I am on Darksky Home Page$")
    public void iAmOnDarkskyHomePage() {
        Assert.assertEquals(SharedSD.getDriver().getTitle(),"DarkSky.net","DarkSky.net");
    }

    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void iVerifyCurrentTempIsNotGreaterOrLessThenTempsFromDailyTimeline() throws Throwable {
        Assert.assertTrue(DarkHomePage.getCurrentTemperature() > DarkHomePage.getMinTemperature()
                && DarkHomePage.getCurrentTemperature() < DarkHomePage.getMaxTemperature());

    }
    //#2
    @When("^I expand todays timeline$")
    public void iExpandTodaysTimeline() throws Throwable {
        DarkHomePage.clickOnExpandIcon();
    }

    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void iVerifyLowestAndHighestTempIsDisplayedCorrectly() throws Throwable {
        Assert.assertEquals(DarkHomePage.getMinTemperature(), DarkHomePage.getMinTemperatureAfterExpand());
        Assert.assertEquals(DarkHomePage.getMaxTemperature(), DarkHomePage.getMaxTemperatureAfterExpand());
    }

    //#3

    @Then ("^I verify timeline is displayed with two hours incremented")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() throws Throwable {
        String arr1 = null;
        String arr2 = null;
        for (int i = 3; i <= 5; i = i + 2) {

            String arr = SharedSD.getDriver()
                    .findElement(By.xpath("//div[@id='timeline']/div/div[3]/span[" + i + "]/span")).getText();

            if (arr.contains("am")) {
                arr = arr.replace("am", "");
                if (i == 3) {
                    arr1 = arr;
                }
                if (i == 5) {
                    arr2 = arr;
                }
            } else {
                arr = arr.replace("pm", "");
                if (i == 3) {
                    arr1 = arr;
                }
                if (i == 5) {
                    arr2 = arr;
                }

            }

        }

        int num1 = Integer.parseInt(arr1);
        int num2 = Integer.parseInt(arr2);
        int diff = num2 - num1;
        Assert.assertEquals(2, diff);
    }


}
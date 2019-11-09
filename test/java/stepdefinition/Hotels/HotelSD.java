 package stepdefinition.Hotels;


 import cucumber.api.java.en.Given;
 import cucumber.api.java.en.Then;
 import cucumber.api.java.en.When;
 import framework.webPages.HotelsHomePage;
 import org.junit.Assert;

 public class HotelSD {

      HotelsHomePage hotelHomePage =new HotelsHomePage();

     @Given ("^I am on hotels\\.com home page$")
     public void iAmOnHotelsComHomePage(){
         int isUserOnHomePage = hotelHomePage.verifyHotelsHomePage();
         Assert.assertTrue(isUserOnHomePage!=0);
     }

     @Then("^I select (\\d+) from room dropdown$")
     public void iSelectRoomsFromRoomDropDown(int arg1) throws InterruptedException {
        // hotelHomePage.selectMoreOptions();
         String room = String.valueOf(arg1);
         hotelHomePage.selectRooms(room);
         Thread.sleep(2000);
     }

     @Then("^I verify (\\d+) is displayed$")
     public void iVerifyNumberOfRoomDropDownIsDisplayed(int arg1){
         hotelHomePage.verifyNumberOfRoomDropDown(arg1);
     }

     /////2
     @Given("^I am on default locations search result screen$")
     public void iAmOnDefaultLocationsSearchResultScreen(){
         int isUserOnSearchResultScreen= hotelHomePage.verifySearchResultScreen();
         Assert.assertTrue(isUserOnSearchResultScreen!=0);
     }

     @When ("^I select property class (\\d+) stars$")
     public void iSelectPropertyClassStars(int arg1) throws InterruptedException {
       hotelHomePage.entervalueInDestinationTextBox();
       Thread.sleep(5000);
       hotelHomePage.clickPopupLink();
       hotelHomePage.clickSearchButton();
       hotelHomePage.selectSearchRatingCheckBox(arg1);
     }

     @Then("^I verify system displays only (\\d+) stars hotels on search result$")
     public void iVerifySystemDisplayOnlyStarsHotelsOnSearchResult(int arg1) throws InterruptedException {
         hotelHomePage.verifyStarRatingResult(arg1);

     }

     /////3
     @Then("^I verify system displays all hotels within (\\d+) miles radius of airport$")
     public void iVerifySystemDisplaysAllHotelsWithin10MilesRadiusOfAirport(int arg1) throws InterruptedException {
         hotelHomePage.entervalueInDestinationTextBox();
         hotelHomePage.clickPopupLink();
         hotelHomePage.clickSearchButton();
         hotelHomePage.verifyHotelsWithinRadius(arg1);

     }

     ///////4

     @Then("^I verify todays deal is less than \\$(\\d+)$")
     public void iVerifyTodaysDealIsLessThen200$(int arg1) throws InterruptedException {
         hotelHomePage.entervalueInDestinationTextBox();
         hotelHomePage.clickPopupLink();
         hotelHomePage.clickSearchButton();
         hotelHomePage.getTodaysDealPrice();
         hotelHomePage.verifyTodaysDealPrice(arg1);
     }


 }
package framework.webPages;

import cucumber.api.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepdefinition.SharedSD;
import util.ConfigReader;

import java.util.List;

public class HotelsHomePage extends BasePage {

   private static By searchButton = By.xpath("//button[@class='cta cta-strong']");
   private static By roomsDropDown = By.name("q-rooms");
   private static By totalRoomsDropDown = By.xpath("//select[contains(@name,'q-room-')]");

   private static int rooms;
   ////
   private By fiveStarCheckBox = By.cssSelector("#f-star-rating-5");
   private By fourStarCheckBox = By.cssSelector("#f-star-rating-4");
   private By threeeStarCheckBox = By.cssSelector("#f-star-rating-3");
   private By fiveStarSearchResultCount = By.xpath("//span[@class='star-rating-text star-rating-text-strong'][contains(text(),'5-star')]");
   private By fourStarSearchResultCount = By.xpath("//span[@class='star-rating-text star-rating-text-strong'][contains(text(),'4-star')]");
   private By threeStarSearchResultCount = By.xpath("//span[@class='star-rating-text'][contains(text(),'3-star')]");
   private By threePointFiveStarSearchResultCount = By.xpath("//span[@class='star-rating-text'][contains(text(),'3.5-star')]");
   private By fourPointFiveStarSearchResultCount = By.xpath("//span[@class='star-rating-text star-rating-text-strong'][contains(text(),'4.5-star')]");
   private By hotelSection = By.xpath("//section[@class='hotel-wrap']");
   private By destinationTextBox = By.id("qf-0q-destination");
   private By closeButton = By.xpath("//button[text()='close']");

   ///
   private By distanceFromAirport = By.xpath("//li[@class='hotel expanded-area']//li[contains(text(),'1.5 miles to John F. Kennedy International Airport')]");

   ///
   private By todaysDealPrice= By.xpath("");
   private By popupLink=By.linkText("Continue to Hotels.com");
   int actualPrice ;



//   public static void selectMoreOptions(){
//      WebElement element = SharedSD.getDriver().findElement(By.id("qf-0q-compact-occupancy"));
//      Select sel = new Select(element);
//      sel.selectByVisibleText("More options…");
//   }

   public static int verifyHotelsHomePage() {
      List<WebElement> elements = SharedSD.getDriver().findElements(searchButton);
      return elements.size();
   }

   public void selectRooms(String text) {
      WebElement element = SharedSD.getDriver().findElement(roomsDropDown);
      Select sel = new Select(element);

      if (text.equals("9")) {
         sel.selectByVisibleText(text + "+");
      } else {
         sel.selectByVisibleText(text);
      }
      rooms = Integer.parseInt(text);
   }

   public void verifyNumberOfRoomDropDown(int number_of_room_dropdown) {
      List<WebElement> elements = SharedSD.getDriver().findElements(totalRoomsDropDown);
      int dropDownCount = elements.size();
      System.out.println(rooms);
      if (number_of_room_dropdown == 0) {
         Assert.assertTrue(dropDownCount == 0);
      }
      Assert.assertEquals(dropDownCount, number_of_room_dropdown * 2);
   }

   ////2
   public void entervalueInDestinationTextBox() throws InterruptedException {
      setValue(destinationTextBox, "John F. Kennedy International Airport (JFK), New York, United States of America");
      Thread.sleep(2000);
      clickOn(closeButton);
   }


   public void clickSearchButton() {
      clickOn(searchButton);
   }

    public void clickPopupLink() {
        clickOn(popupLink);
    }

   public int verifySearchResultScreen() {
      List<WebElement> elements = SharedSD.getDriver().findElements(searchButton);
      return elements.size();
   }

   public void selectSearchRatingCheckBox(int star) {
      if (star == 5) {
         clickOn(fiveStarCheckBox);
      }
      if (star == 4) {
         clickOn(fourStarCheckBox);
      }
      if (star == 3) {
         clickOn(threeeStarCheckBox);
      }
   }

   public void verifyStarRatingResult(int star) throws InterruptedException {
      //scrollToBottom(SharedSD.getDriver().findElements(seeAllAvailableHotelsText));
      for (int i = 0; i <= 50; i++) {
         JavascriptExecutor jse = (JavascriptExecutor) SharedSD.getDriver();
         jse.executeScript("window,scrollBy(0,250)");
         Thread.sleep(1000);
         System.out.println(star);
      }

      if (star == 5) {
         Assert.assertEquals(SharedSD.getDriver().findElements(fiveStarSearchResultCount).size(), SharedSD.getDriver().findElements(hotelSection).size());
      }
      if (star == 4) {
         Assert.assertEquals(SharedSD.getDriver().findElements(fourStarSearchResultCount).size()+SharedSD.getDriver().findElements(fourPointFiveStarSearchResultCount).size(), SharedSD.getDriver().findElements(hotelSection).size());
      }
      if (star == 3) {
         Assert.assertEquals(SharedSD.getDriver().findElements(threeStarSearchResultCount).size()+SharedSD.getDriver().findElements(threePointFiveStarSearchResultCount).size(), SharedSD.getDriver().findElements(hotelSection).size());
      }
   }

   //3
   public void verifyHotelsWithinRadius(int radius){
      List<WebElement> distance = SharedSD.getDriver().findElements(distanceFromAirport);
       for (int i=0; i<distance.size();i++){
          String [] text = distance.get(i).getText().split("");
          Assert.assertTrue(Float.parseFloat(text[0])<(float)radius);
       }
   }

   //4

   public void getTodaysDealPrice(){
      List<WebElement> prices= SharedSD.getDriver().findElements(todaysDealPrice);
      String price = prices.get(0).getText();

      actualPrice= Integer.parseInt(price);
   }

   public void verifyTodaysDealPrice(int price){
      Assert.assertTrue(actualPrice<price);
   }




}

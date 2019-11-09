package stepdefinition;

import cucumber.api.java.en.Given;
import framework.webPages.HomePage;
import framework.webPages.MessengerLoginPage;
import framework.webPages.MessengerPage;
import org.testng.Assert;

public class MessengerSD {

    private HomePage homePage = new HomePage();
    private MessengerPage messengerPage = new MessengerPage();
    private MessengerLoginPage messengerLoginPage = new MessengerLoginPage();

    @Given("^I am on messenger page$")
    public void setMessengerPage() {
        homePage.clickOnMessengerLink();
        Assert.assertEquals(SharedSD.getDriver().getCurrentUrl(), "https://www.messenger.com/");
    }


}

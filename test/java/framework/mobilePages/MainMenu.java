package framework.mobilePages;

import framework.MobileBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainMenu extends MobileBasePage {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Menu']")
    private MobileElement sidebarHeader;

    public boolean isMenuPresent() {
        return isElementDisplayed(sidebarHeader);
    }

}

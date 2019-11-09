package framework.webPages;

import org.openqa.selenium.By;

public class DarkskyHomePage extends BasePage {
    private By signUpLink=By.linkText("Sign Up");
    private By currentTemprature=By.xpath("//div[@id='title']//span[@class='summary swap']");
    private By todayMinTemperature=By.xpath("//div[@id='week']/a[1]/span[2]/span[1]");
    private By todayMaxTemperature=By.xpath("//div[@id='week']/a[1]/span[2]/span[3]");
    private By timelineExpand=By.xpath("//*[@id='week']/a[1]");
    private By todayMinTemperatureAfterExpand=By.xpath("//div[@id='week']/div[2]/div[1]/div[2]/div[1]/span[1]/span[1]");
    private By todayMaxTemperatureAfterExpand=By.xpath("//div[@id='week']/div[2]/div[1]/div[2]/div[1]/span[3]/span[1]");



    public int getCurrentTemperature() {
        String arr[]=getTextFromElement(currentTemprature).split(" ");
        arr[0] = arr[0].replaceAll("[^a-zA-Z0-9]", "");
        return Integer.parseInt(arr[0]);
    }
    public int getMinTemperature() {
        String minTemp=getTextFromElement(todayMinTemperature);
        minTemp=minTemp.replaceAll("[^a-zA-Z0-9]", "");
        return Integer.parseInt(minTemp);
    }

    public int getMaxTemperature() {
        String maxTemp=getTextFromElement(todayMaxTemperature);
        maxTemp=maxTemp.replaceAll("[^a-zA-Z0-9]", "");
        return Integer.parseInt(maxTemp);
    }

    public void clickOnExpandIcon() throws InterruptedException {
        scrollToElement(timelineExpand);
        Thread.sleep(2000);
        clickOn(timelineExpand);
    }

    public int getMinTemperatureAfterExpand() {
        String minTemp=getTextFromElement(todayMinTemperatureAfterExpand);
        minTemp=minTemp.replaceAll("[^a-zA-Z0-9]", "");
        return Integer.parseInt(minTemp);
    }

    public int getMaxTemperatureAfterExpand() {
        String maxTemp=getTextFromElement(todayMaxTemperatureAfterExpand);
        maxTemp=maxTemp.replaceAll("[^a-zA-Z0-9]", "");
        return Integer.parseInt(maxTemp);
    }

}


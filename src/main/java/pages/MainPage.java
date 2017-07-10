package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import services.Driver;
import services.Screenshoter;

public class MainPage extends AbstractPage{
    private final By HEADER_USERNAME_LOCATOR = By.xpath("//div[@class='header__user']/span[@class='header__username']");
    private final By EXIT_LOCATOR = By.xpath("//a[@role='link' and contains(@href,'https://passport.yandex.ru?mode=logout')]");
    private final By PROMO_LOCATOR = By.xpath("//div[@class='create-resource-popup-with-anchor__promo-office-shade']");
    private final By VIEW_RADIO_BUTTON_LOCATOR = By.xpath("//input[@class='radio-button__control']");
    private final By TILE_RADIO_BUTTON_LOCATOR = By.xpath("//input[@class='radio-button__control' and @value='tile']");
    private final By ICONS_RADIO_BUTTON_LOCATOR = By.xpath("//input[@class='radio-button__control' and @value='icons']");
    private final By LIST_RADIO_BUTTON_LOCATOR = By.xpath("//input[@class='radio-button__control' and @value='list']");
    private final By HIDE_SHOW_LAST_LOADED_FILES_LOCATOR = By.xpath("//div[@class='toolset__children']/button[1]");
    private final By CLOSE_SAVE_TIME_WINDOW_LOCATOR = By.xpath("//div[@class='_nb-popup-i']/a");
    private final By SAVE_TIME_WINDOW_LOCATOR = By.xpath("//div[@class='_nb-popup-content']");


    public MainPage doubleClicking(){

        return this;
    }


    public MainPage changeViewOfFiles(){
//        waitForElementVisible(ICONS_RADIO_BUTTON_LOCATOR);
//        highlightElement(ICONS_RADIO_BUTTON_LOCATOR);
        Driver.getDriverInstance().findElement(ICONS_RADIO_BUTTON_LOCATOR).click();
//        unHighlightElement(HEADER_USERNAME_LOCATOR);
//        if(!Driver.getDriverInstance().findElement(ICONS_RADIO_BUTTON_LOCATOR).getAttribute("value").contains("tile")){
//            Driver.getDriverInstance().findElement(ICONS_RADIO_BUTTON_LOCATOR).click();
//        }
        return this;
    }

    public MainPage hideLastLoadedFiles(){
        Driver.getDriverInstance().findElement(HIDE_SHOW_LAST_LOADED_FILES_LOCATOR).click();
//        waitForElementVisibleEnabled(HIDE_SHOW_LAST_LOADED_FILES_LOCATOR);
//        if (Driver.getDriverInstance().findElement(HIDE_SHOW_LAST_LOADED_FILES_LOCATOR).getAttribute("aria-pressed").contains("true")){
//            Driver.getDriverInstance().findElement(HIDE_SHOW_LAST_LOADED_FILES_LOCATOR).click();
//        }
        return this;
    }

    public MainPage closePromo(){
//        waitForElementVisibleEnabled(PROMO_LOCATOR);
//        if(isElementPresent(PROMO_LOCATOR)){
//            Driver.getDriverInstance().findElement(PROMO_LOCATOR).click();
//        }
        return this;
    }

    public MainPage closeSaveTimeWindow(){
//        waitForElementVisibleEnabled(SAVE_TIME_WINDOW_LOCATOR);
//        if(isElementPresent(SAVE_TIME_WINDOW_LOCATOR)){
//            Driver.getDriverInstance().findElement(CLOSE_SAVE_TIME_WINDOW_LOCATOR).click();
//        }
        return this;
    }

    public LoginPage logOut(){
        waitForElementVisibleEnabled(HEADER_USERNAME_LOCATOR);
//        highlightElement(HEADER_USERNAME_LOCATOR);
        Driver.getDriverInstance().findElement(HEADER_USERNAME_LOCATOR).click();
//        unHighlightElement(HEADER_USERNAME_LOCATOR);
//        driver.findElement(EXIT_LOCATOR).click();
        String executeString = Driver.getDriverInstance().findElement(EXIT_LOCATOR).getAttribute("href");
        ((JavascriptExecutor)Driver.getDriverInstance()).executeScript(executeString);
        Screenshoter.takeScreenshot();
        return new LoginPage();
    }


}

package pages;

import org.openqa.selenium.By;
import services.Driver;

public class LoginPage extends AbstractPage{
    private final String BASE_URL = "https://disk.yandex.ru";
    private final String userName = "cool.tests2018";
    private final String pwdName = "1q2w3e4r5T";
    private final By USERNAME_LOCATOR = By.xpath(".//input[@name='login']");
    private final By PASSWORD_LOCATOR = By.xpath(".//input[@name='password']");
    private final By LOGIN_BUTTON_LOCATOR = By.xpath(".//button[@type='submit' and @role='button']");

    public LoginPage open(){
        Driver.getDriverInstance().get(BASE_URL);
        return this;
    }

    public MainPage login(){
        Driver.getDriverInstance().findElement(USERNAME_LOCATOR).sendKeys(userName);
        Driver.getDriverInstance().findElement(PASSWORD_LOCATOR).sendKeys(pwdName);
        Driver.getDriverInstance().findElement(LOGIN_BUTTON_LOCATOR).click();
        return new MainPage();
    }

}

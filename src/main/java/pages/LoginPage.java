package pages;

import org.openqa.selenium.support.PageFactory;
import pages.blocks.LoginBlock;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;
import services.Driver;

public class LoginPage extends AbstractPage{
    private final String BASE_URL = "https://disk.yandex.ru";
    private LoginBlock loginBlock;
    private final String userName = "cool.tests2018";
    private final String pwdName = "1q2w3e4r5T";


    public LoginPage open(){
        Driver.getDriverInstance().get(BASE_URL);
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(Driver.getDriverInstance())), this);
        return this;
    }

    public MainPage login(){
        loginBlock.logIn(userName,pwdName);
        return new MainPage();
    }

}

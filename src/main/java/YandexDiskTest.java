import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import services.Screenshoter;
import services.Driver;

public class YandexDiskTest {
    private WebDriver driver;
    public String[] arrayOfFileName =
            {"1426364091_412325540.jpg","418034.jpg", "Rogue-One-Star-Wars-Story-Main-Characters.jpg",
            "izgoj-odin-zvezdnye-vojny-istorii-2016-48.jpg", "maxresdefault (1).jpg", "maxresdefault.jpg", "starwarsrogueone_1t.jpg", "Море.jpg"};

    @Test(description = "Login to Yandex Disk")
    public void loginToYandex(){
        new LoginPage().open().login();
        Screenshoter.takeScreenshot();
    }

    @Test(dependsOnMethods = "loginToYandex", description = "Preview picture")
    public void chooseAndPreview(){
        MainPage mainPage = new MainPage().changeViewOfFiles();
        mainPage.hideLastLoadedFiles();
//        MainPage mainPage = new MainPage().closePromo().closeSaveTimeWindow().hideLastLoadedFiles().changeViewOfFiles();
//        MainPage mainPage = new MainPage().changeViewOfFiles();

    }

//    @Test(description = "Open folder")
//    public void openFolder(){
//
//    }
//
//    @Test(description = "Drag picture to folder")
//    public void dragPicture(){
//
//    }
//
//    @Test(description = "Remove picture")
//    public void removeToTrach(){
//
//    }

//    @Test(dependsOnMethods = "chooseAndPreview", description = "Logout from Yandex Disk")
//    public void logoutFromYandex(){
//        LoginPage mainPage = new MainPage().logOut();
//        Screenshoter.takeScreenshot();
//    }

    @AfterClass(description = "Close browser")
    public void closeBrowser() {
        Driver.closeBrowser();
    }
}

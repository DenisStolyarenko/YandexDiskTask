package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 20;

    protected boolean isElementPresent(By locator) {
        return !Driver.getDriverInstance().findElements(locator).isEmpty();
    }

    protected boolean isElementPresentOnPage(By locator){
        Driver.getDriverInstance().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> list = Driver.getDriverInstance().findElements(locator);
        Driver.getDriverInstance().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (list.size() == 0) {
            return false;
        } else {
            return list.get(0).isDisplayed();
        }
    }

    protected void waitForElementPresent(By locator) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementVisible(By locator) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementEnabled(By locator) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementVisibleEnabled(By locator) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(
                ExpectedConditions.and(
                        ExpectedConditions.visibilityOfAllElementsLocatedBy(locator),
                        ExpectedConditions.elementToBeClickable(locator)));
    }

    protected void highlightElement(By locator) {
        ((JavascriptExecutor) Driver.getDriverInstance()).executeScript("arguments[0].style.border='3px solid yellow'", Driver.getDriverInstance().findElement(locator));
    }

    protected void unHighlightElement(By locator) {
        ((JavascriptExecutor) Driver.getDriverInstance()).executeScript("arguments[0].style.border='0px'", Driver.getDriverInstance().findElement(locator));
    }
}

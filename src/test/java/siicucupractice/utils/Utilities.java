package siicucupractice.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.net.MalformedURLException;

import static siicucupractice.config.WebDriverSingleton.getInstance;

public class Utilities {

    public void waitForVisibility(WebElement element, long timeOutInSeconds) throws Error, MalformedURLException {
        new WebDriverWait(getInstance(), timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
    }

    public void hoverElement(WebElement element){
        Actions action = new Actions(getInstance());
        action.moveToElement(element);
        action.perform();
    }

    public void scrollToElement(WebElement element) {
        //WebElement element = getDriverWait().waitShort().until(ExpectedConditions.presenceOfElementLocated(selectElementByType.getelementbytype(accessType, accessName)));
        JavascriptExecutor executor = (JavascriptExecutor) getInstance();
        executor.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickElementWithDelay(WebElement element) throws MalformedURLException {
        waitForVisibility(element, 1);
        element.click();
    }

    public void clickElement(WebElement element) throws MalformedURLException {
        element.click();
    }

    public void putTextIntoElement(WebElement element, String inPutText) throws MalformedURLException {
        waitForVisibility(element, 1);
        element.sendKeys(inPutText);
    }
}

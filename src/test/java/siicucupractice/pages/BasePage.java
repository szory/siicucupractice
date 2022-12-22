package siicucupractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siicucupractice.utils.Utilities;

import java.net.MalformedURLException;
import static siicucupractice.config.WebDriverSingleton.getInstance;

public class BasePage extends Utilities {

    public BasePage() {
        PageFactory.initElements(getInstance(), this);
    }
}
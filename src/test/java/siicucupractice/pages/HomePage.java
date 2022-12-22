package siicucupractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    @FindBy(css = "[title=\"Log in to your customer account\"]")
    private WebElement signInButton;

    public void clickOnSignInButton() throws MalformedURLException {
        clickElementWithDelay(signInButton);
    }
}

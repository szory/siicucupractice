package siicucupractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

import static siicucupractice.config.WebDriverSingleton.getInstance;

public class CreateEmailPage extends BasePage{

    public CreateEmailPage(){
        super();
    }

    private final String technicalErrorPopUpMessageCssSelector = "#authentication > div.fancybox-overlay.fancybox-overlay-fixed > div";

    @FindBy(id = "email")
    private WebElement registeredEmailInput;

    @FindBy(id = "passwd")
    private WebElement registeredPasswordInput;

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id ="SubmitLogin")
    private WebElement signInButton;

    @FindBy(css = technicalErrorPopUpMessageCssSelector)
    private WebElement technicalErrorPopUpMessage;

    @FindBy(css = "#authentication > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a")
    private WebElement technicalErrorPopUpMessageCloseBtn;

    public void fillInCreateAccountForm(String emailAddress) {
        emailInput.sendKeys(emailAddress);
    }

    public void clickCreateAccountButton(){
        createAccountButton.click();
    }

    public WebElement getCreateAccountBtn(){
        return createAccountButton;
    }

    public WebElement getTechnicalErroMsg(){
        return technicalErrorPopUpMessage;
    }

    public WebElement getTechnicalErroMsgCloseBtn(){
        return technicalErrorPopUpMessageCloseBtn;
    }

    public boolean checkIfExistsErrorMsg() throws InterruptedException {
        //Thread.currentThread().sleep(1000);
        if (getInstance().findElements(By.cssSelector(technicalErrorPopUpMessageCssSelector)).size() > 0)
            return true;
        else
            return false;
    }

    public void fillUpLoginPassTextBoxesAndLogInto() throws MalformedURLException {
        putTextIntoElement(registeredEmailInput, "szory81@o2.pl");
        putTextIntoElement(registeredPasswordInput,"M@ngo81");
        clickElement(signInButton);
    }
}

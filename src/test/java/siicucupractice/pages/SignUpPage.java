package siicucupractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import siicucupractice.config.DataFaker;

import java.net.MalformedURLException;
import java.util.List;

public class SignUpPage extends BasePage {

    private DataFaker faker = new DataFaker();

    public SignUpPage() {
        super();
    }

    @FindBy(id = "id_gender1")
    private WebElement maleTitleRadioBtn;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstnameInput;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastnameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement birthdayDaySelect;

    @FindBy(id = "months")
    private WebElement birthdatMonthSelect;

    @FindBy(id = "years")
    private WebElement birthdayYearSelect;

    @FindBy(id = "address1")
    private WebElement addressLineInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement stateSelect;

    @FindBy(id = "postcode")
    private WebElement zipCodeInput;

    @FindBy(id = "phone_mobile")
    private WebElement phoneNumberInput;

    @FindBy(id = "submitAccount")
    private WebElement submitFormBtn;

    @FindBy(css = "#center_column > .alert li")
    private List<WebElement> alertMessageContent;

    public WebElement getMaleTitle(){
        return maleTitleRadioBtn;
    }

    public void clickSubmitFormBtn(){
        submitFormBtn.click();
    }

    public void fillInRegistrationForm(/*boolean validForm*/) throws MalformedURLException {
        waitForVisibility(maleTitleRadioBtn,10);
        maleTitleRadioBtn.click();
//        if (validForm) {
            customerFirstnameInput.sendKeys(faker.getFakeFirstname());
//        }
        customerLastnameInput.sendKeys(faker.getFakeLastname());
        passwordInput.sendKeys(faker.getFakePassword());
        new Select(birthdayDaySelect).selectByValue("4");
        new Select(birthdatMonthSelect).selectByValue("10");
        new Select(birthdayYearSelect).selectByValue("1990");
        addressLineInput.sendKeys(faker.getFakeStreet());
        cityInput.sendKeys(faker.getFakeCity());
        new Select(stateSelect).selectByValue("4");
        zipCodeInput.sendKeys("11234");
        phoneNumberInput.sendKeys(faker.getFakeMobilePhone());
    }
}

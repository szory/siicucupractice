package siicucupractice.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import siicucupractice.pages.CreateEmailPage;
import siicucupractice.pages.HomePage;
import com.github.javafaker.Faker;
import siicucupractice.pages.ProfilePage;
import siicucupractice.pages.SignUpPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.MalformedURLException;

public class registerNewUser {
    final HomePage hp = new HomePage();
    private Faker faker = new Faker();

    @Given("click on sign in button")
    public void clickOnRegisterButton() throws MalformedURLException {
        hp.clickOnSignInButton();
    }

    @When("Submit create account form with valid email")
    public void createNewAccount() throws InterruptedException {
        CreateEmailPage createEmailPage = new CreateEmailPage();
        createEmailPage.fillInCreateAccountForm(faker.internet().emailAddress());
        createEmailPage.clickCreateAccountButton();
        if (createEmailPage.checkIfExistsErrorMsg()){
            createEmailPage.getTechnicalErroMsgCloseBtn().click();
            createEmailPage.clickCreateAccountButton();
        }
    }

    @When("fill up all fields for register process")
    public void fillAllFieldsOfFormular() throws MalformedURLException {
        SignUpPage signUpPage = new SignUpPage();
        //signUpPage.waitForVisibility(signUpPage.getMaleTitle(),10);
        signUpPage.fillInRegistrationForm();
        signUpPage.clickSubmitFormBtn();
    }

    @Then("get success webpage with proper message {string}")
    public void getMessageRegistrationProcess(String message){
        ProfilePage profilePage = new ProfilePage();
        String profilePageHeaderText = profilePage.getProfilePageHeaderText();
        assertEquals(message, profilePageHeaderText);
    }
}
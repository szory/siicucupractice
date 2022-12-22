package siicucupractice.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions;
import siicucupractice.pages.CreateEmailPage;
import siicucupractice.pages.OrderPage;
import siicucupractice.pages.ProductTopMenu;
import siicucupractice.pages.ProductsPage;

import java.net.MalformedURLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class purchaseProduct{
    OrderPage orderPage = new OrderPage();
    CreateEmailPage createEmailPage = new CreateEmailPage();
    ProductTopMenu myAccountPage = new ProductTopMenu();
    ProductsPage productsPage = new ProductsPage();

    @Given("login into website")
    public void login_into_website() throws MalformedURLException {
        createEmailPage.fillUpLoginPassTextBoxesAndLogInto();
    }
    @When("click on menu woman")
    public void click_on_menu_woman() throws MalformedURLException {
        myAccountPage.chooseFromMenuWomanItem();
    }
    @Then("check if product id is in stock:")
    public void check_if_product_is_in_stock(List<String> list) {
        for (String id: list) {
            assertTrue(productsPage.checkIfProductExistsOnList(id), "Product with id " + id + " is not available in stock");
            assertTrue(productsPage.checkIfProductIsInStock(id), "Product with id " + id + " has insufficient amount in stock");
        }
    }
    @Then("put a product with id {string} into the cart")
    public void put_a_product_into_the_cart(String id) throws MalformedURLException {
        try {
            productsPage.clickAddToCart(id);
        } catch (Exception e) {
            Assertions.assertTrue(false, "Product with id "+id+" is not available in stock");
        }
    }
    @And("check if cart has a {string}")
    public void check_if_cart_is_not_empty(String product) throws MalformedURLException {
        // Write code here that turns the phrase above into concrete actions
        productsPage.checkIfcartIsNotEmpty();
        Assertions.assertTrue(productsPage.getCartTopBtn().getText().contains(product),"cart should contains "+product+" literal");
    }
    @When("click cart button to proceed purchase")
    public void click_on_popup_button_proceed_to_checkout() throws MalformedURLException {
        productsPage.proceedPurchase();
    }
    @Then("check if product is on list {string}")
    public void check_if_product_is_on_list(String string) {
        Assertions.assertEquals(string, orderPage.getCartDescription().getText());
    }

    @And("^click \"([button|checkout]*)\" on Order Page \"([a-zA-Z0-9_\\s]*)\"$")
    public void click_proceed_to_checkout_button(String mode,String page) throws MalformedURLException {
        orderPage.clickProceedBtn(page,mode);
    }
    @Then("check delivery address {string}")
    public void check_delivery_address(String streetAddress) {
        Assertions.assertEquals(streetAddress, orderPage.getStreetAddress().getText());
    }
    @Then("check bill address {string}")
    public void check_bill_address(String billingAddress) {
        Assertions.assertEquals(billingAddress, orderPage.getBillingAddress().getText());
    }
    @And("choose payment manner {string}")
    public void choose_payment_manner(String modePayment) {
        orderPage.choosePayment(modePayment);
    }
    @Then("check if payment mode {string} is correct")
    public void check_if_payment_mode_is_correct(String mode) {
        String getPaymentModeText = orderPage.paymentModeText();
        Assertions.assertTrue(getPaymentModeText.contains(mode), "Payment mode "+getPaymentModeText+" is incorrect than expected "+mode);
    }
}

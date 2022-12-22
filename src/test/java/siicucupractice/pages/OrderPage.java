package siicucupractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class OrderPage extends BasePage {

    private final String billingAddressCommonCss = "#address_invoice";
    private final String deliveryAddressCommonCss = "#address_delivery";

    public OrderPage(){
        super();
    }

    @FindBy(css = "td.cart_description > p > a")
    private WebElement cartDescription;
    public WebElement getCartDescription() {
        return cartDescription;
    }

    @FindBy(css = "a.button.btn.btn-default.standard-checkout.button-medium")
    private WebElement proceedCheckoutSummaryBtn;
    public WebElement getProceedCheckoutSummaryBtn() {
        return proceedCheckoutSummaryBtn;
    }

    @FindBy(css = "#center_column > form > p > button")
    private WebElement proceedCheckoutAddressBtn;
    public WebElement getProceedCheckoutAddressBtn() {
        return proceedCheckoutAddressBtn;
    }

    @FindBy(css = "#form > p > button")
    private WebElement proceedCheckoutShippingBtn;
    public WebElement getProceedCheckoutShippingBtn() {
        return proceedCheckoutShippingBtn;
    }

    @FindBy(css = deliveryAddressCommonCss+" > li.address_address1.address_address2")
    private WebElement streetAddress;
    public WebElement getStreetAddress() {
        return streetAddress;
    }

    @FindBy(css = billingAddressCommonCss+" > li.address_address1.address_address2")
    private WebElement billingAddress;
    public WebElement getBillingAddress() {
        return billingAddress;
    }

    @FindBy(css = "#cgv")
    private WebElement shippingAgreeCheck;
    public WebElement getshippingAgreeCheck() {
        return shippingAgreeCheck;
    }

    @FindBy(css = "#HOOK_PAYMENT")
    private WebElement hookPaymentSection;
    private WebElement PayByBtn(String payMode){
        return hookPaymentSection.findElement(By.cssSelector("a[title=\""+payMode+"\"]"));
    }
    public void choosePayment(String mode){
        PayByBtn(mode).click();
    }

    @FindBy(css = "#cart_navigation > button")
    private WebElement confirmOrderBtn;

    @FindBy(css = "#center_column > form > div > h3")
    private WebElement paymentMode;
    public String paymentModeText(){
        return paymentMode.getText();
    }

    //Step functions
    public void clickProceedBtn(String page, String mode) throws MalformedURLException {
        if (mode.equals("button"))
            switch (page){
                case "proceed to checkout button in Shipping": clickElement(getProceedCheckoutShippingBtn()); break;
                case "proceed to checkout button in Summary": clickElement(getProceedCheckoutSummaryBtn()); break;
                case "proceed to checkout button in Address": clickElement(getProceedCheckoutAddressBtn()); break;
                case "confirm button": clickElement(confirmOrderBtn); break;
        }
        else if ((mode.equals("checkout"))){
            switch (page){
                case "agree with terms of service": clickElement(getshippingAgreeCheck()); break;
            }
        }
    }
}

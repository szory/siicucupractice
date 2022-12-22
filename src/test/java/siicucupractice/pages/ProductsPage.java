package siicucupractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.net.MalformedURLException;
import java.util.List;

public class ProductsPage extends BasePage{
    public ProductsPage() {
        super();
    }

    private final String commonCenterColumn_ul = "#center_column > ul";

    //WebElements
    @FindBy(css=commonCenterColumn_ul)
    private WebElement commonProductContainer;

    @FindBy(css=commonCenterColumn_ul+"> li")
    private List<WebElement> ListOfProductsInContainer;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span")
    private WebElement continueShoopingBtn;
    public WebElement getContinueShoopingBtn(){
        return continueShoopingBtn;
    }

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    private WebElement cartTopBtn;
    public WebElement getCartTopBtn(){
        return cartTopBtn;
    }

    //Steps functions
    public boolean checkIfProductExistsOnList(String id) {
        try {
            if (commonProductContainer.findElement(cssLocatorToProductById(id)).getAttribute("data-id-product").toString().equals(id)) {
                return true;
            }
        }catch (Exception ex){
            //return false;
        }
        return false;
    }

    public boolean checkIfProductIsInStock(String idProduct){
        WebElement element = findProductWebElementInStockById(idProduct);
        if (element != null) {
            if (element.findElements(cssLocatorInStock()).size() > 0) {
                return true;
            }
        }
        return false;
    }

    public void checkIfcartIsNotEmpty() throws MalformedURLException {
        waitForVisibility(getContinueShoopingBtn(),10);
        getContinueShoopingBtn().click();
        hoverElement(getCartTopBtn());
    }

    public void clickAddToCart(String idProduct) throws Exception {
        WebElement element = findProductWebElementInStockById(idProduct);
        if (element != null) {
            //scrollToElement(element);
            hoverElement(element);
            clickElementWithDelay(element.findElement(cssLocatorToProductById(idProduct)));
        }else
            throw new Exception();
    }

    public void proceedPurchase() throws MalformedURLException {
        hoverElement(getCartTopBtn());
        clickElementWithDelay(getCartTopBtn());
    }

    //internal functions
    private WebElement findProductWebElementInStockById(String idProduct){
        for (WebElement element: ListOfProductsInContainer){
            if (element.findElements(cssLocatorToProductById(idProduct)).size() > 0){
                return element;
            }
        }
        return null;
    }

    private By cssLocatorToProductById(String idProduct){
        return By.cssSelector("li > div > div.right-block > div.button-container > a[data-id-product=\""+idProduct+"\"]");
    }

    private By cssLocatorInStock(){
        return By.cssSelector("li > div > div.right-block > span[class=\"availability\"]");
    }
}
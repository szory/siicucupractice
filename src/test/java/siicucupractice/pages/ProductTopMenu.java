package siicucupractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.util.List;

import static siicucupractice.config.WebDriverSingleton.getInstance;

public class ProductTopMenu extends BasePage{
    ProductsPage productsPage = new ProductsPage();
    public ProductTopMenu() {
        super();
    }

    @FindBy(css="#block_top_menu > ul > li:nth-child(1) > a")
    private WebElement productsMenuWomenBtn;

    @FindBy(css="#block_top_menu > ul > li:nth-child(1) > ul > li:nth-child(1) > ul > li:nth-child(1) > a")
    private WebElement productsMenuWomen_TshirtLink;

    public WebElement getProductsMenuWomenBtn(){
        return productsMenuWomenBtn;
    }

    public WebElement getProductsMenuWomen_TshirtLink(){
        return productsMenuWomen_TshirtLink;
    }

    public void chooseFromMenuWomanItem() throws MalformedURLException {
        clickElement(getProductsMenuWomenBtn());
    }
}
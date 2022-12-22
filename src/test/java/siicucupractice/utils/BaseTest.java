package siicucupractice.utils;

import siicucupractice.pages.CreateEmailPage;
import siicucupractice.pages.OrderPage;
import siicucupractice.pages.ProductTopMenu;
import siicucupractice.pages.ProductsPage;

public interface BaseTest {
    OrderPage orderPage = new OrderPage();
    CreateEmailPage createEmailPage = new CreateEmailPage();
    ProductTopMenu myAccountPage = new ProductTopMenu();
    ProductsPage productsPage = new ProductsPage();
}

package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchandCartTest extends BaseTest {

    @Test(priority = 1)

    public void searchedProductTest(){

        ProductPage productPage=new ProductPage(page).open().searchProduct("tops");

        assertThat(productPage.results().first()).isVisible();


    }

    @Test(priority = 2)

    public void addtoCartTest(){

        ProductPage productPage=new ProductPage(page).open().searchProduct("Winter top");

        productPage.viewProduct().addToCart();

        CartPage cartPage=productPage.viewCart();


        assertThat(cartPage.getItems().first()).containsText("Winter Top");
    }
}

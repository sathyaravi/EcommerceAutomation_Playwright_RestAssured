package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkOut(){

        LoginPage loginPage = new LoginPage(page).open();

        loginPage.login("Jane143@mail.com","Test@12345");

        ProductPage productPage=new ProductPage(page).open().searchProduct("Winter Top");

        productPage.viewProduct().addToCart();

        CartPage cartPage=productPage.viewCart();

        assertThat(cartPage.getItems().first()).containsText("Winter Top");

        CheckoutPage checkoutPage=cartPage.proceedCheckout();

        assertThat(checkoutPage.reviewHeading()).isVisible();

        assertThat(checkoutPage.deliveryAddress()).containsText("255 privet drive");

        assertThat(checkoutPage.orderItems()).containsText("Winter Top");

        PaymentPage paymentPage=checkoutPage.placeOrder();

        ConfirmationPage confirmationPage=paymentPage.paymentInfo("Jane Doe", "4111111111111111", "123", "12", "2030");

        assertThat(confirmationPage.orderPlaced()).isVisible();

        assertThat(confirmationPage.successMessage()).isVisible();

        loginPage.logout();
    }


}

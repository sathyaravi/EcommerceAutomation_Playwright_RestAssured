package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage {

    private final Page page;

    public CheckoutPage(Page page){

        this.page=page;
    }


    public Locator reviewHeading(){

        return page.getByText("Review Your Order");
    }

    public Locator deliveryAddress(){

        return page.locator("#address_delivery");
    }

    public Locator orderItems(){

        return page.locator(".cart_description");
    }

    public PaymentPage placeOrder(){

        page.getByText("Place Order", new Page.GetByTextOptions().setExact(true)).click();

        return new PaymentPage(page);
    }

}

package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage {

    private final Page page;


    public CartPage(Page page){

        this.page=page;
    }


    public Locator getItems(){

        return page.locator(".cart_description");


    }
}

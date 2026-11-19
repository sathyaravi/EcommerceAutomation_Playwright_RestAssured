package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ConfirmationPage {

    private final Page page;

    public ConfirmationPage(Page page){

        this.page=page;
    }

    public Locator orderPlaced(){

        return page.locator("[data-qa='order-placed']");
    }

    public Locator successMessage(){

        return page.getByText("Congratulations! Your order has been confirmed!");
    }

}

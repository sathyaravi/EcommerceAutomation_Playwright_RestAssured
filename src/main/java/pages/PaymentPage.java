package pages;

import com.microsoft.playwright.Page;

public class PaymentPage {

    private final Page page;

    public PaymentPage(Page page){

        this.page=page;
    }

    public ConfirmationPage paymentInfo(String name,String cardNumber,String cvc,String month,String year){

        page.locator("//input[@name='name_on_card']").fill(name);

        page.locator("input[name='card_number']").fill(cardNumber);

        page.getByPlaceholder("ex. 311").fill(cvc);

        page.getByPlaceholder("MM").fill(month);

        page.getByPlaceholder("YYYY").fill(year);

        page.getByText("Pay and Confirm Order").click();

        return new ConfirmationPage(page);
    }
}

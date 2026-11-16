package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;

    public HomePage(Page page){

        this.page=page;
    }

    public void open(){

        page.navigate("https://automationexercise.com");
    }

    public String title(){

        return page.title();
    }
}

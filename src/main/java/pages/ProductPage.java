package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductPage {

    private final Page page;

    public ProductPage(Page page){

        this.page=page;
    }

    public ProductPage open(){

        page.navigate("/products");

        return this;
    }


    public ProductPage searchProduct(String productname) {


        page.locator("//ul[@class='nav navbar-nav']//li//a[@href='/products']").click();

        page.getByPlaceholder("Search Product").fill(productname);

        page.locator("#submit_search").click();


        return this;

    }

    public Locator results() {


        return page.locator(".product-image-wrapper");

    }

    public ProductPage viewProduct() {


       results().first().getByText("View Product").click();

        return this;
    }

    public ProductPage addToCart() {


        page.getByText("Add to cart").click();

        return this;
    }


    public CartPage viewCart(){

        page.getByText("View Cart", new Page.GetByTextOptions().setExact(true)).click();

        return new CartPage(page);
    }



}

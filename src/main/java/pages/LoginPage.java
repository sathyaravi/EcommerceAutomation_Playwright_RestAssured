package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage{

    private final Page page;

    String baseurl;

    private static final String EMAIL="//input[@data-qa=\"login-email\"]";

    private static final String PASSWORD="//input[@data-qa=\"login-password\"]";

    private static final String LOGIN_BUTTON="//button[@data-qa=\"login-button\"]";


    private static final String LOGGED_IN="text=Logged in as";


    private static final String LOGGED_INERROR="text=Your email or password is incorrect!";



    public LoginPage(Page page){

        this.page=page;


    }

    public LoginPage open(){

        page.navigate("/login");

        return this;
    }

    public void login(String email,String password) {


        page.locator(EMAIL).fill(email);

        page.locator(PASSWORD).fill(password);

        page.locator(LOGIN_BUTTON).click();
    }

    public Locator LoggedInLabel() {

        return page.locator(LOGGED_IN);

    }

    public Locator errorMessage() {

        return page.locator(LOGGED_INERROR);
    }


    public void logout() {
        page.getByText("Logout").click();
    }


}

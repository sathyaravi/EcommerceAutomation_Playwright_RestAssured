package ui;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageTest extends BaseTest {


    @Test
    public void validLoginPage(){

        LoginPage loginPage=new LoginPage(page).open();

        loginPage.login("Jane143@mail.com","Test@12345");

        assertThat(loginPage.LoggedInLabel()).isVisible();


    }

    @Test
    public void invalidLoginPage(){

        LoginPage loginPage=new LoginPage(page).open();

        loginPage.login("Jane14@mail.com","Test@12345");

        assertThat(loginPage.errorMessage()).isVisible();



    }


}

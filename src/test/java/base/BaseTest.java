package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Playwright playwright;

    protected Browser browser;

    protected BrowserContext browserContext;

    protected Page page;



    @BeforeMethod

    public void setUp(){

        playwright=Playwright.create();

        browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));


        browserContext=browser.newContext(
                new Browser.NewContextOptions().setBaseURL("https://automationexercise.com"));
        browserContext.route("**/*googlesyndication*/**", route -> route.abort());
        browserContext.route("**/*doubleclick*/**", route -> route.abort());


        page= browserContext.newPage();

    }



    @AfterMethod

    public void tearDown(){

        browserContext.close();

        browser.close();

        playwright.close();
    }


}

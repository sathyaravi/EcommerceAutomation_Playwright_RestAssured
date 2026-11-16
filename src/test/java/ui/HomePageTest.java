package ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void homePage(){

        HomePage homePage = new HomePage(page);

        homePage.open();

        Assert.assertTrue(homePage.title().contains("Automation Exercise"));
    }
}

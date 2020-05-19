package tests.vytrack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import pages.LoginPage;

import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class CalendarEventTest extends TestBase {

    @Test(description = "Verify that page subtitle is equals to 'All Calendar Events")
    public void test1(){
        LoginPage loginPage = new LoginPage ();
        String username= ConfigurationReader.getProperty ( "user_name" );
        String password= ConfigurationReader.getProperty ( "password" );
        loginPage.login ( username,password );

        loginPage.navigateTo ( "Activities","Calendar Events" );
        loginPage.waitUntilLoaderMaskDisappear ();
        String expectedSubtitle = "All Calendar Events";
        String actualSubTitle= loginPage.getSubtitle ();

        Assert.assertEquals ( actualSubTitle,expectedSubtitle );




    }
}

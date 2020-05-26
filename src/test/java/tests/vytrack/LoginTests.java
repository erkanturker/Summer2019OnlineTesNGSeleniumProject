package tests.vytrack;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.ConfigurationReader;
import utils.Driver;

//We write extends TestBase to inherit @before and @after method
//This class will be dedicated to tests related to Login Page
//we dont have to find elements here
//we should find elemts inpage class only

public class LoginTests extends TestBase {
    @Test(description = "Verify that page title is a Dashboard")
    public void test1 ( ) {
        extentTest = extentReports.createTest ("Verify that page title is a Dashboard"  );
        //Create a page object
        LoginPage loginPage = new LoginPage ();

        //WE got the username and passwor from configuration class
        String userName = ConfigurationReader.getProperty ( "user_name" );
        String passwoRd = ConfigurationReader.getProperty ( "password" );

        //We used login method that we created in LoginPage and
        loginPage.login ( userName, passwoRd );

        //This is an explicit wait
        // it waits until title is Dahboard

        WebDriverWait wait = new WebDriverWait ( Driver.get (), 10 );
        wait.until ( ExpectedConditions.titleIs ( "Dashboard" ) );

        Assert.assertEquals ( Driver.get ().getTitle (), "Dashboard" );
        extentTest.pass ( "veried that page title 'Dashboad' was displayed " );

    }

}

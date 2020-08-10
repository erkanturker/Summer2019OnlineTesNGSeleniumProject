package tests.homework.homework03;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;

public class TestCase1 extends TestBase {

    @Test(description = "Verify that page subtitle \"Options\" is displayed")
    public void test1(){
        extentTest = extentReports.createTest ("Verify that page subtitle is equals to 'Option"  );
        LoginPage  loginPage= new LoginPage ();
        String username= ConfigurationReader.getProperty ( "user_name" );
        String password = ConfigurationReader.getProperty ( "password" );
        loginPage.login ( username,password );
        loginPage.waitUntilLoaderMaskDisappear ();
        loginPage.navigateTo ( "Activities", "Calendar Events");
        loginPage.waitUntilLoaderMaskDisappear ();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage ();
        Assert.assertEquals (calendarEventsPage.getOptionString (),"Options");
        Assert.assertEquals ( calendarEventsPage.getPageBumber (),"1" );
    }
    @Test(description = "Verify that page number is equals to \"1\"")
    public void test2(){
        extentTest = extentReports.createTest ("Verify that page subtitle is equals to 'Option"  );
        LoginPage loginPage= new LoginPage ();
        String username= ConfigurationReader.getProperty ( "user_name" );
        String password = ConfigurationReader.getProperty ( "password" );
        loginPage.login ( username,password );
        loginPage.waitUntilLoaderMaskDisappear ();
        loginPage.navigateTo ( "Activities", "Calendar Events");
        loginPage.waitUntilLoaderMaskDisappear ();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage ();
        Assert.assertEquals ( calendarEventsPage.getPageBumber (),"1" );
    }

}

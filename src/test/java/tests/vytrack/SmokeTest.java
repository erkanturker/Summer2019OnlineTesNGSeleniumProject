package tests.vytrack;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;

public class SmokeTest extends TestBase {
    @Test(dataProvider = "navigationInfo")
    public void smokeTest (String menuName, String subMenuName, String pageSubTitle) {
        extentTest = extentReports.createTest ( "Verify that page subtitle is equals to " + pageSubTitle );
        LoginPage loginPage = new LoginPage ();
        //WE got the username and passwor from configuration class
        String userName = ConfigurationReader.getProperty ( "user_name" );
        String passwoRd = ConfigurationReader.getProperty ( "password" );
        loginPage.login ( userName, passwoRd );
        loginPage.waitUntilLoaderMaskDisappear ();
        loginPage.navigateTo ( menuName,subMenuName );

        Assert.assertEquals ( pageSubTitle,loginPage.getSubtitle () );
        extentTest.pass ( "Verified That page subtitle " + pageSubTitle + " Displayed" );

    }

    @DataProvider(name = "navigationInfo")
    public Object[][] navigationInfo ( ) {
        return new Object[][]{
                //menu          //submenu    //page titile
                {"Dashboards", "Dashboard", "Dashboard"},
                {"Dashboards", "Manage Dashboards", "All Manage Dashboards"},
                {"Fleet", "Vehicles", "All Cars"},
                {"Customers", "Accounts", "All Accounts"}
        };

    }


}

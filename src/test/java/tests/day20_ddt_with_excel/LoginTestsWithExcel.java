package tests.day20_ddt_with_excel;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.Driver;
import utils.ExcelUtil;
import java.util.Map;

public class LoginTestsWithExcel extends TestBase {
    @DataProvider(name = "credentials")
    public static Object[][] credentials ( ) {
        ExcelUtil qa2 = new ExcelUtil ( "vytrack_testusers.xlsx", "QA2-short" );
        return qa2.getDataArray ();
    }

    @Test(dataProvider = "credentials", description = "login with different credentials")
    public void loginTest (String username, String password, String firstName, String lastName, String result) {
        extentTest = extentReports.createTest ( "Login as " + username );
        if (username.equals ( "username" )) {
            throw new SkipException ( "Test was skipped because of the first row" );
        } else {
            LoginPage loginPage = new LoginPage ();
            loginPage.login ( username, password );
            loginPage.waitUntilLoaderMaskDisappear ();
            Assert.assertEquals ( Driver.get ().getTitle (), "Dashboard" );
            extentTest.pass ( "Login test passed for user " + username );
        }

    }

    /*
    public static void main (String[] args) {
        ExcelUtil qa2 = new ExcelUtil ( "vytrack_testusers.xlsx","QA2-short" );
        System.out.println ("row count: "+qa2.rowCount ());
        System.out.println (qa2.getColumnsNames ());

        //map is a data structure
        //in map,every value is reference by key
        //when we retrive data from map,we don't specify index , we specify key names
        //keys must be uniqe
        //keys are repsented here with column name
        for (Map<String,String> map: qa2.getDataList ()){
            System.out.println (map.get ( "username" )); // username is key value
        }
    }

     */
    //is a test data provider
    //as many sets of data it returns
    //as many times excatly same test will run

}

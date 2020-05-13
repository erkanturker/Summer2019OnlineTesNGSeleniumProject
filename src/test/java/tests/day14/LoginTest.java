package tests.day14;

import org.junit.Ignore;
import org.testng.annotations.Test;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginTest extends TestBase {
    @Test
    public void test2 ( ) {
        System.out.println ( Driver.get ().getTitle () );
    }


    @Ignore
    @Test(description = "login")
    public void test1 ( ) {
        //read url value from the properties file
        String url = ConfigurationReader.getProperty ( "url" );
        //Driver.get()"We created" will return webDriver Object
        //another get method belongs to Webdriver interface and it class url
        Driver.get ().get ( url );
        BrowserUtils.wait ( 2 );
        Driver.close ();
    }
}

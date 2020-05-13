package tests;
//this class will be a test foundation for all test classes
// we will put here only before and after parts
//in this way before and after method will be te same
//Every test class will extedn testbase class

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigurationReader;
import utils.Driver;

public abstract class TestBase {
    @BeforeMethod
    public void setup ( ) {
        String url = ConfigurationReader.getProperty ( "url" );
        Driver.get ().get ( url );
    }

    @AfterMethod
    public void tearDown(){
        Driver.close ();
    }


}

package tests.day14;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigurationReader;

public class ConfigureReaderTest {
    @Test
    public void test1(){
        String expectedBrowser = "chrome";
        //WE write keys in "key" as a string
        // as return you will get value
        //Key=value
        String actualBrowser= ConfigurationReader.getProperty ( "browser" );
        Assert.assertEquals ( actualBrowser,expectedBrowser );
        System.out.println ("URL: "+ConfigurationReader.getProperty ( "url" ));
        System.out.println ("Username: "+ ConfigurationReader.getProperty ( "user_name" ));
        System.out.println ("Password: "+ConfigurationReader.getProperty ( "password" ));

    }
}

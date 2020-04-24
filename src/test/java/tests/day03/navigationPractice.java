package tests.day03;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class navigationPractice {
    public static void main (String[] args) {
        WebDriver driver= BrowserFactory.getDriver ( "chrome" );
        driver.manage ().window ().maximize ();
        driver.get ( "http://google.com" );
        BrowserUtils.wait ( 3 );
        // wait for 3 second
        // this is out custom method
        // since method is static, we can use lass name to call the method
        // as a parameter we provide number of seconds

        driver.navigate ().to ( "http://amazon.com" );
        //navigate back to google.com
        driver.navigate ().back ();
        //move forward to the amazon gaing
        driver.navigate ().forward ();
        driver.navigate ().refresh ();





    }
}

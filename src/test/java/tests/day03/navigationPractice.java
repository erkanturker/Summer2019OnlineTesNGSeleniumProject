package tests.day03;

import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class navigationPractice {
    public static void main (String[] args) {
        WebDriver driver= BrowserFactory.getDriver ( "chrome" );
        driver.manage ().window ().maximize ();
        driver.get ( "http://google.com" );
        driver.navigate ().to ( "http://amazon.com" );
        //navigate back to google.com
        driver.navigate ().back ();
        //move forward to the amazon gaing
        driver.navigate ().forward ();
        driver.navigate ().refresh ();




    }
}

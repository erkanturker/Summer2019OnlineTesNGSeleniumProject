package tests.day03;


import utils.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class BrowserFactoryTest {

    public static void main (String[] args) {
        //now we can driver like this
        //get() method will return webdriver object
        // abd we cab use refenrence variable to work with that object

       WebDriver driver = BrowserFactory.getDriver ( "chrome" );
       driver.get ( "http://practice.cybertekschools.com" );
        System.out.println (driver.getPageSource ());
        driver.quit ();



    }
}

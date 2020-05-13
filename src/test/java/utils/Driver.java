package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;

    //if the contructor driver you can not create an objcet thats our goal
    private Driver ( ) {
    }

    public static WebDriver get ( ) {
        //create webdriver if it isnot started
        if (driver == null) {
            //Thats way our method know hot to call which browser // if we change the Configuration file with firefox it will open firefix
            String browser = ConfigurationReader.getProperty ( "browser" );
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver ().setup ();
                    driver = new ChromeDriver ();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver ().setup ();
                    driver = new FirefoxDriver ();
                    break;
                default:
                    // if browser type is wrong stop tests and throw exception it will not return object
                    throw new RuntimeException ( "Wrong browser type" );
            }
        }
        return driver;
    }

    public static void close ( ) {
        //if driver still exit
        if (driver != null) {
            //close all browser
            driver.quit ();
            //destroy driver object and for gc
            driver = null;
        }
    }
}

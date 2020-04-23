package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
   // we are going to create a method that will return a webriver object
    // this method will take one paramater - String Browser
    // if browser = chrome then return chromedriver object

    public static WebDriver getDriver(String browser){
        if(browser.equalsIgnoreCase ( "chrome" )){
            WebDriverManager.chromedriver ().setup ();
            return new ChromeDriver (  );
        }
        else if (browser.equalsIgnoreCase ( "firefox" )){
            WebDriverManager.firefoxdriver ().setup ();
            return new FirefoxDriver (  );
        }
        return null;
    }





}

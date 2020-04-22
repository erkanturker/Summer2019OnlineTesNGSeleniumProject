package tests.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main (String[] args) {
        WebDriverManager.chromedriver ().setup ();
        ChromeDriver chromeDriver = new ChromeDriver (  );

        chromeDriver.get ( "http://google.com" );
        chromeDriver.navigate ().to ( "http://amazon.com" );
        chromeDriver.manage ().window ().fullscreen (); /// maximize browser
        chromeDriver.navigate ().back (); // going back to the previous page
        String url = chromeDriver.getCurrentUrl ();
        System.out.println (url);
        chromeDriver.close ();
    }
}

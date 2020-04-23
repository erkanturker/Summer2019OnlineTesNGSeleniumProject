package tests.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceBetweenQuitandClose {
    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver ().setup ();
        ChromeDriver chromeDriver =new ChromeDriver (  );
        chromeDriver.get ( "http://practice.cybertekschool.com/open_new_tab" );
        Thread.sleep ( 4000 );
        //chromeDriver.close (); //will close only one tab
        chromeDriver.quit ();
    }

}

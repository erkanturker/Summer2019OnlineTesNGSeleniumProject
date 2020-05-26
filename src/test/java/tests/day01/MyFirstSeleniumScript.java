package tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserFactory;

public class MyFirstSeleniumScript {
    public static void main (String[] args) {

        //we have to setup deiver based on the browser that we will use
        WebDriverManager.chromedriver ().setup ();
        //we need to create an object of appropriate class

        ChromeDriver chromeDriver =new ChromeDriver (  );

        //lets open google.com

        chromeDriver.get ( "https://www.facebook.com" );

        String actualResult= chromeDriver.getTitle ();
        String expectedResult = "Facebook - Log In or Sign Up";
        System.out.println (actualResult);

        if(actualResult.equals ( expectedResult )){
            System.out.println ("Test Past");
        }
        else System.out.println ("Test Failed");
    chromeDriver.close ();



    }
}

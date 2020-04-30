package tests.day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

/*
Let's go cybertekschool.com
And find number of links and print this number


 */
public class Task01 {
    public static void main (String[] args) {
        WebDriver driver = BrowserFactory.getDriver ( "Chrome" );
        driver.get ( "http://cybertekschool.com" );
        int linkNumber= driver.findElements ( By.tagName ("a") ).size ();
        System.out.println (linkNumber);
        // vasly
        List< WebElement > links = driver.findElements ( By.xpath ("//a") );
        System.out.println (links.size ());
        int number =0;

        for (WebElement each: links) {
            if (!each.getText ().isEmpty ()) {
                System.out.println ( each.getText () );
                number++;
                System.out.println ( number );
            }
        }
            System.out.println ( number );
            driver.close ();


    }
}

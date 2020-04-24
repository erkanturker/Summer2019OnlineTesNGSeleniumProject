package tests.day04;
/*
##Test 1: Verify that URL has not changed
Go to http://practice.cybertekschool.com/forgot_password
Click on retrieve password button
Verify that page title didn't change (in this case, we verify that same page is still open)
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class task01 {
    public static void main (String[] args) {
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/forgot_password" );
        String currentTitle= driver.getTitle ();
        WebElement element = driver.findElement ( By.id ( "form_submit" ) );
        element.click ();
        BrowserUtils.wait ( 2 );
        if(!currentTitle.equals ( driver.getTitle () )){
            System.out.println ("Test Failed");
            driver.close ();
        }
        else System.out.println ("test Past "+currentTitle);

    }
}

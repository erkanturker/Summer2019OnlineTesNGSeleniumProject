package tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

/*
###Test 2, Verify that URL changed
1. Go to "http://practice.cybertekschool.com/forgot_password"
2. Enter any valid email
3. Click on retrieve password button
4. Verify that URL is equals to "http://practice.cybertekschool.com/email_sent"

 */
public class task02 {
    public static void main (String[] args) {

        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/forgot_password" );
        WebElement inputbox= driver.findElement ( By.name ("email"  ) );
        inputbox.sendKeys ( "example@exp.com" );
        System.out.println (inputbox.getAttribute ( "pattern" ));
        //This is the method we can use what we type
        System.out.println (inputbox.getAttribute ( "value" ));


        WebElement button= driver.findElement ( By.id ( "form_submit" ) );
        button.submit (); // if it is submit element we can call submit method
       // button.click ();



        String expectedURL= "http://practice.cybertekschool.com/email_sent";
        String actualURL = driver.getCurrentUrl ();
        if(expectedURL.equals ( actualURL )){
            System.out.println ("Test Passed");
        }
        else {
            System.out.println ("Test Failed");
        }
        BrowserUtils.wait ( 2 );
        driver.close ();
    }
}

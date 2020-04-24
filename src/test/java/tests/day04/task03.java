package tests.day04;

/*
##Test 3, Verify that confirmation message is displayed
1. Go to "http://practice.cybertekschool.com/forgot_password"
2. Enter any valid email
3. Click on retrieve password button
4. Verify that message "Your e-mail's been sent!" is displayed

 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class task03 {
    public static void main (String[] args) {
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/forgot_password" );
        WebElement inputbox= driver.findElement ( By.name ("email"  ) );
        inputbox.sendKeys ( "example@exp.com", Keys.ENTER ); //Will simulate enter button we do not add the following

        //WebElement button= driver.findElement ( By.id ( "form_submit" ) );
        //button.click ();

        WebElement confirmationMessage= driver.findElement ( By.name ( "confirmation_message" ) );
        String actualmessage = confirmationMessage.getText ();
        String expectedmessage = "Your e-mail's been sent!";
        if (expectedmessage.equals ( actualmessage )){
            System.out.println ("Test Passed");
        }
        else {
            System.out.println ("Test Failed");
        }



        BrowserUtils.wait ( 2 );
        driver.close ();
    }
}

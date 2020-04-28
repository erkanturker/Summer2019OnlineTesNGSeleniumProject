package tests.homework.homework01;
/*
Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into first name input box.
Step 4. Verify that warning message is displayed: “first name can only consist of alphabetical letters”

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class TestCase04 {
    public static void main (String[] args) {
        WebDriver driver= BrowserFactory.getDriver ( "chrome" );
        driver.get ( "https://practice-cybertekschool.herokuapp.com/" );
        driver.findElement ( By.xpath ("//a[text()='Registration Form']") ).click ();
        driver.findElement (By.xpath ( "//input[@name='firstname']" )  ).sendKeys ( "123" );

        String expectedmessage= "first name can only consist of alphabetical letters";
        String actualmessage= driver.findElement ( By.xpath ( "//small[contains(text(),'irst name can only consist of alphabetical letters')]" ) ).getText ();
        if (expectedmessage.equals ( actualmessage )){
            System.out.println (actualmessage);
            System.out.println ("test pass");
        }
        else System.out.println ("test failed");




    }
}

package tests.homework.homework01;

/*
Step 1. Go to https://practice-
cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into last name input box.
Step 4. Verify that warning message is displayed: “The last name can only consist of alphabetical letters and dash”
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class TestCase05 {
    public static void main (String[] args) {
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "https://practice-cybertekschool.herokuapp.com" );

        driver.findElement ( By.xpath ("//a[text()='Registration Form']") ).click ();
        driver.findElement ( By.cssSelector ( "input[name='lastname']" ) ).sendKeys ( "123" );

        String actualmessage = driver.findElement (By.cssSelector ( "small[data-bv-validator='regexp'][data-bv-for='lastname']" ) ).getText ();
        String expectedMessage= "The last name can only consist of alphabetical letters and dash";

        if(actualmessage.equals ( expectedMessage )){
            System.out.println (actualmessage);
            System.out.println ("tesT passed");
        }
        else{
            System.out.println ("Test Failed");
        }





        driver.close ();

    }
}

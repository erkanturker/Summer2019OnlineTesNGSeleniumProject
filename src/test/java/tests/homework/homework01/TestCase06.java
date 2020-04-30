package tests.homework.homework01;
/*

Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “user” into username input box.
Step 4. Verify that warning message is displayed: “The username must be more than 6 and less than 30 characters long”

 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase06 {
    public static void main (String[] args) {
        WebDriverManager.chromedriver ().setup ();
        ChromeDriver driver = new ChromeDriver (  );
        driver.get ( "https://practice-cybertekschool.herokuapp.com" );

        driver.findElement ( By.xpath ( "//a[text()='Registration Form']" ) ).click ();
        driver.findElement ( By.cssSelector (  "input[name='username']" )).sendKeys ( "user" );
        String actualMessage= driver.findElement ( By.cssSelector ( "small[data-bv-validator='stringLength'][data-bv-for='username']" ) ).getText ();
        String expectedMessage= "The username must be more than 6 and less than 30 characters long";
        if(actualMessage.equals ( expectedMessage )){
            System.out.println (actualMessage);
            System.out.println ("test passed");
        }
        else System.out.println ("test failed");



    }

}

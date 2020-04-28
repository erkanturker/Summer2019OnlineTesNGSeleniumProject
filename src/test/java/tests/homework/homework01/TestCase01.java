package tests.homework.homework01;

/*
Step 1. Go to https://practice-
cybertekschool.herokuapp.com
Step 2. Click on “Sign Up For Mailing List” Step 3. Enter any valid name
Step 4. Enter any valid email
Step 5. Click on “Sign Up” button
Expected result: Following message should be displayed: “Thank you for signing up.
Click the button below to return to the home page.” Home button should be displayed.

 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestCase01 {
    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver ().setup ();
        ChromeDriver driver= new ChromeDriver (  );
        driver.get("https://practice-cybertekschool.herokuapp.com/");

        driver.findElement ( By.xpath ( "//*[text() = 'Sign Up For Mailing List']" ) ).click ();
        driver.findElement ( By.xpath ( "//input[@name='full_name']" ) ).sendKeys ( "Example" );
        driver.findElement ( By.name ( "email" ) ).sendKeys ( "example@exp.com" );
        driver.findElement ( By.xpath ( "//button[@name='wooden_spoon']" ) ).click ();
        String actualmessage = driver.findElement ( By.name ( "signup_message" ) ).getText ();
        String expectedmessage =  "Thank you for signing up. Click the button below to return to the home page.";
        if (expectedmessage.equals ( actualmessage )){
            System.out.println (actualmessage);
            System.out.println ("test passed");
        }
        else System.out.println ("Test Failed");
        Thread.sleep ( 3000 );

       driver.close ();







    }
}

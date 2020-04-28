package tests.homework.homework01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.BrowserUtils;

/*
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step2. Click on “Multiple Buttons”
Step3. Click on “Button 1”
Verify that result message is displayed: “Clicked on button one!”
 */
public class TestCase03 {
    public static void main (String[] args) {
        WebDriverManager.chromedriver ().setup ();
        ChromeDriver driver = new ChromeDriver (  );

        driver.get ( "https://practice-cybertekschool.herokuapp.com/" );
        BrowserUtils.wait ( 2 );
        driver.findElement(By.xpath ( "//*[text()='Multiple Buttons']" )).click ();
        driver.findElement ( By.xpath ( "//button[@onclick='button1()']" ) ).click ();
        String expectedmessage= "Clicked on button one!";
        String actualmessage= driver.findElement ( By.id ( "result" ) ).getText ();
        if (actualmessage.equals ( expectedmessage )){
            System.out.println (actualmessage);
            System.out.println ("Test Passed");
        }
        else System.out.println ("test Failed");





    }
}

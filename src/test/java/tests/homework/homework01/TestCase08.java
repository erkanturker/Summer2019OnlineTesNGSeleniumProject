package tests.homework.homework01;
/*
Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “5711234354” into phone number input box.
Step 4. Verify that warning message is displayed: “Phone format is not correct”

 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase08 {
    public static void main (String[] args) {
        WebDriverManager.chromedriver ().setup ();
        ChromeDriver driver = new ChromeDriver (  );
        driver.get ( "https://practice-cybertekschool.herokuapp.com" );

        driver.findElement ( By.xpath ( "//a[text()='Registration Form']" ) ).click ();
        driver.findElement ( By.cssSelector ( "input[name='phone']" ) ).sendKeys ( "5711234354" );
        String actualMessage = driver.findElement ( By.cssSelector ( "small[data-bv-for='phone'][data-bv-validator='regexp']" ) ).getText ();
        String expectedMessage= "Phone format is not correct";

        if (actualMessage.equals ( expectedMessage )){
            System.out.println (actualMessage);
            System.out.println ("Test Passed");
        }
        else System.out.println ("test failed");
    }
}

package tests.homework.homework01;
/*
Step 1. Go to https://practice-
cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “testers@email” into email input box.
Step 4. Verify that warning message is displayed: “email address is not a valid
Email format is not correct”

 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase07 {
    public static void main (String[] args) {
        WebDriverManager.chromedriver ().setup ();
        ChromeDriver driver = new ChromeDriver (  );
        driver.get ( "https://practice-cybertekschool.herokuapp.com" );

        driver.findElement ( By.xpath ( "//a[text()='Registration Form']" ) ).click ();
        driver.findElement ( By.cssSelector ( "input[name='password']" ) ).sendKeys ( "testers@email" );




    }
}

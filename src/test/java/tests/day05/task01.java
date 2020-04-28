package tests.day05;
/*
1. Go to http://practice.cybertekschool.com/multiple_buttons
2. find the dont click button and click it
3. get the result message.

 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;


public class task01 {
    public static void main (String[] args) {
        WebDriverManager.chromedriver ().setup ();
        ChromeDriver driver = new ChromeDriver (  );
        driver.get ( "http://practice.cybertekschool.com/multiple_buttons" );


        WebElement dButton= driver.findElement ( By.id ("disappearing_button") );
        dButton.click ();

        WebElement heading1= driver.findElement ( By.id("result") );
        System.out.println (heading1.getText ());

        driver.quit ();





    }
}

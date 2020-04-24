package tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class EnterTextPractice {
    public static void main (String[] args) {
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/forgot_password" );
        WebElement inputbox= driver.findElement ( By.name( "email" ) );
        inputbox.sendKeys ( "example@exp.com" );
        WebElement button = driver.findElement ( By.id ( "form_submit" ) );
        button.click ();
        BrowserUtils.wait ( 2 );
        driver.close ();


    }
}

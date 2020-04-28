package tests.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class task06tagNameLocator {
    public static void main (String[] args) throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );

        driver.get ( "http://practice.cybertekschool.com/sign_up" );

        driver.findElement ( By.name ("full_name") ).sendKeys ( "Test User" );
        driver.findElement ( By.name ( "email" ) ).sendKeys ( "test@email.com" );
        driver.findElement ( By.name ( "wooden_spoon" ) ).click ();

        Thread.sleep ( 3000 );

        WebElement tag_name = driver.findElement ( By.tagName ( "h3" ) );
        System.out.println (tag_name.getText ());
    }
}

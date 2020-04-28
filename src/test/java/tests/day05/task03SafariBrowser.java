package tests.day05;

/*
go to http://practice.cybertekschool.com/sign_up
type 1st text box Test user
type 2nd text box type email
and click submit button and close the browser
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class task03SafariBrowser {
    public static void main (String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.manage ().window ().fullscreen ();
        driver.get ( "http://practice.cybertekschool.com/sign_up" );
        driver.findElement ( By.name ("full_name") ).sendKeys ( "Test User" );
        driver.findElement ( By.name ( "email" ) ).sendKeys ( "test@email.com" );
        driver.findElement ( By.name ( "wooden_spoon" ) ).click ();

        Thread.sleep ( 3000 );

        driver.quit ();






    }
}

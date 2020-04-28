package tests.day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public class task02BtrixLogin {
    public static void main(String[] args){
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "https://login1.nextbasecrm.com/" );
        driver.findElement ( By.xpath ("//input[@name='USER_LOGIN']") ).sendKeys (  "example@example.com");
        //enter password
        // * martches any element
        driver.findElement ( By.xpath ( "//*[@name='USER_PASSWORD']" ) ).sendKeys ( "useruser" );

        ////input[]ue, 'Log')] we can use like this start with
        //
        driver.findElement ( By.xpath ( "//input[@class='login-btn']" ) ).submit ();
        driver.findElement ( By.xpath ( "//input[@name='full_name']" ) ).sendKeys ( "Example" );
        driver.findElement ( By.name ( "email" ) ).sendKeys ( "example@exp.com" );
        driver.findElement ( By.xpath ( "//button[@name='wooden_spoon']" ) ).click ();


    }
}

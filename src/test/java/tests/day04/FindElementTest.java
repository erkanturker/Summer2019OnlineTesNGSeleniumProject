package tests.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class FindElementTest {
    public static void main (String[] args) {
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/forgot_password" );
        //Step1 Open instepector in chrome and find locator of the element
        //Step2 Create object of WebElement
        //Step3 Use WebElement
        WebElement button=driver.findElement ( By.id ( "form_submit" ) );
        //to click on the element
        button.click ();
        BrowserUtils.wait ( 2 );
        driver.close ();


    }
}

package tests.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class task07LinkText {
    public static void main (String[] args) {
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/" );
        WebElement getLink= driver.findElement ( By.linkText ("Autocomplete") );
        getLink.click ();
        BrowserUtils.wait ( 3 );

        driver.quit ();




    }


}

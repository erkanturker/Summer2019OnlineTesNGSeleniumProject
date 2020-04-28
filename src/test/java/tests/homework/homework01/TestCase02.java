package tests.homework.homework01;
/*
Step 1. Go to https://practice- cybertekschool.herokuapp.com
Step 2. Verify that number of listed examples is equals to 48.
Hint: use findElemnts() and size() methods.

 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

import java.util.List;

public class TestCase02 {
    public static void main (String[] args) {
        WebDriver driver= BrowserFactory.getDriver ( "chrome" );
        driver.get ( "https://practice-cybertekschool.herokuapp.com/" );
        int number = driver.findElements ( By.className ( "list-group-item" ) ).size ();
        System.out.println (number);
        driver.close ();


    }
}

package tests.day05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;

public class task05ClassNameLocator {
    public static void main (String[] args) {
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/multiple_buttons" );

        WebElement heading = driver.findElement ( By.className ("h3") );
        System.out.println (heading.getText ());
    }
}

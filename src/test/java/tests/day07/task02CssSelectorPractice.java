package tests.day07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;

public class task02CssSelectorPractice {
    public static void main (String[] args) {

        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/multiple_buttons" );
        //let find all buttons and click on them one by oneList
        // why i out . instead of space because it is 2 class names btn and btn-primary
        //in this case we will find all buttons that have class="btn btn-primary
        //[class='btn btn-primary'] we can use with braclet as well
        List<WebElement>buttonlists = driver.findElements ( By.cssSelector(".btn.btn-primary") );
        //loop through all the buttons
        for (WebElement elementbutton :buttonlists){
            //click on every button one by one
            elementbutton.click ();
            BrowserUtils.wait ( 1 );
            //
        }
        driver.close ();





    }
}

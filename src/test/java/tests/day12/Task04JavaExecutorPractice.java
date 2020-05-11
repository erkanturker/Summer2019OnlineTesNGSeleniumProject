package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Task04JavaExecutorPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup ( ) {
        driver = BrowserFactory.getDriver ( "chrome" );

    }

    @Test(description = "Scrolling with java script executor")
    public void test1 ( ) {
        driver.get ( "http://practice.cybertekschool.com/infinite_scroll" );
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            js.executeScript ( "  window.scrollBy(0,10000)" );
            BrowserUtils.wait ( 1 );

        }

    }

    @Test(description = "")
    public void test2 ( ) {
        driver.get ( "http://practice.cybertekschool.com/large" );

        WebElement link = driver.findElement ( By.linkText ( "Cybertek School" ) );
        BrowserUtils.wait ( 2 );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //this script must scroll, until link elemet is not visible
        //once link element will be bisible it will stop scrolling
        //argument[0]  means  first webelement after comma
        //arguments its an array of weblements after comma
        //arguments[0] represents the link, it can be any webelement

        js.executeScript ( "arguments[0].scrollIntoView(true)", link );
        BrowserUtils.wait ( 2 );
    }

    @Test(description = "Click with java executor")
    public void test3 ( ) {
        driver.get ( "http://practice.cybertekschool.com/dynamic_loading" );
        WebElement link = driver.findElement ( By.partialLinkText ( "Example 1" ) );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        BrowserUtils.wait ( 2 );
        js.executeScript ( "arguments[0].click", link );
    }

    @Test(description = "Enter text with JavaScript")
    public void test4 ( ) {
        driver.get ( "http://practice.cybertekschool.com/sign_up" );

        WebElement name = driver.findElement ( By.name ( "full_name" ) );
        WebElement email = driver.findElement ( By.name ( "email" ) );
        WebElement submitbutton =driver.findElement ( By.name ( "wooden_spoon" ) );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].setAttribute('value','Erkan Turker')",name );
        js.executeScript ( "arguments[0].setAttribute('value','example@exm.com')",email );
        js.executeScript ( "arguments[0].click()",submitbutton );


        BrowserUtils.wait ( 2 );



    }

    @AfterMethod
    public void after ( ) {
        driver.quit ();
    }
}

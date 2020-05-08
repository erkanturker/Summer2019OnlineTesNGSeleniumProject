package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class Task04Review {
    private WebDriver driver;

    @BeforeMethod
    public void setup ( ) {
        driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/" );
    }

    @Test(description = "clickin black radio button")
    public void test1 ( ) {
        driver.findElement ( By.linkText ( "Radio Buttons" ) ).click ();
        BrowserUtils.wait ( 2 );
        WebElement radiobutton = driver.findElement ( By.cssSelector ( "#black" ) );
        radiobutton.click ();
        Assert.assertTrue ( radiobutton.isSelected (), "The Radio button is not selected" );

    }

    @Test(description = "Clicking all radio buttons")
    public void test2 ( ) {
        driver.findElement ( By.linkText ( "Radio Buttons" ) ).click ();
        BrowserUtils.wait ( 2 );
        List< WebElement > listradiobuttons = driver.findElements ( By.cssSelector ( "input[type='radio']" ) );

        for (WebElement eachbuttons : listradiobuttons) {
            if (eachbuttons.isEnabled () && !eachbuttons.isSelected ()) {
                eachbuttons.click ();
                System.out.println ( eachbuttons.getText () + " was clicked" );
            } else {
                System.out.println ( eachbuttons.getText () + " was NOT clicked" );
            }
            BrowserUtils.wait ( 2 );
        }

    }

    @Test(description = "Dropdown menu")
    public void test3 ( ) {
        driver.findElement ( By.linkText ( "Dropdown" ) ).click ();
        WebElement dropdown = driver.findElement ( By.id ( "dropdown" ) );
        Select select = new Select ( dropdown );
        select.selectByValue ( "2" );
        List< WebElement > options = select.getOptions ();
        for (WebElement each : options) {
            System.out.println ( each.getText () );
        }

        BrowserUtils.wait ( 2 );


    }

    @Test(description = "put your Birthday")
    public void test4 ( ) {
        driver.findElement ( By.linkText ( "Dropdown" ) ).click ();
        WebElement year = driver.findElement ( By.cssSelector ( "[id='year']" ) );
        Select selectyear = new Select ( year );
        selectyear.selectByVisibleText ( "1990" );
        BrowserUtils.wait ( 1 );
        WebElement month = driver.findElement ( By.id ( "month" ) );
        Select selectmont = new Select ( month );
        selectmont.selectByVisibleText ( "June" );
        BrowserUtils.wait ( 1 );
        WebElement day = driver.findElement ( By.id ( "day" ) );
        Select selectday = new Select ( day );
        selectday.selectByVisibleText ( "19" );
        BrowserUtils.wait ( 1 );

    }

    @Test(description = "Select your state and verfy that state is selected by value")
    public void test5 ( ) {
        driver.findElement ( By.linkText ( "Dropdown" ) ).click ();
        WebElement state = driver.findElement ( By.id ( "state" ) );
        Select selectstate = new Select ( state );
        selectstate.selectByValue ( "IN" );
        BrowserUtils.wait ( 2 );
        Assert.assertEquals ( selectstate.getFirstSelectedOption ().getText (),"Indiana");

    }


    @AfterMethod
    public void tearDown ( ) {
        driver.quit ();
    }
}

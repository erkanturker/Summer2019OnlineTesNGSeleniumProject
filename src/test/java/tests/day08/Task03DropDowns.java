package tests.day08;

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

import java.util.List;

/*
<select id="dropdown">
      <option value="" disabled="disabled" selected="selected">Please select an option</option>
      <option value="1">Option 1</option>
      <option value="2">Option 2</option>
    </select>
 */
public class Task03DropDowns {
    private WebDriver driver;

    @BeforeMethod
    public void setup ( ) {
        driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/" );
        driver.findElement ( By.linkText ( "Dropdown" ) ).click ();

    }

    @Test(description = "Select option 2 from the dropdown")
    public void test1 ( ) {
        //to work with select dropdown we need to use Select Class in Selenium
        //Step 1 find dripdown and create Webelement
        WebElement dropdown = driver.findElement ( By.id ( "dropdown" ) );
        //Step 2 create a select object
        Select select = new Select ( dropdown );
        //to selct any option by visible text
        select.selectByVisibleText ( "Option 2" );
        BrowserUtils.wait ( 2 );
        //how to verify that option 2 is selected
        Assert.assertEquals ( select.getFirstSelectedOption ().getText (), "Option 2" );
    }

    @Test(description = "Print list of States")
    public void test2 ( ) {
        WebElement state = driver.findElement ( By.id ( "state" ) );
        Select select = new Select ( state );
        List< WebElement > stateslist = select.getOptions (); //will return availabe options to select
        //how to print all states
        for (WebElement states : stateslist) {
            System.out.println ( states.getText () );

        }
    }

    @Test(description = "Select your state and verfy that state is selected by value")
    public void test3 ( ) {
        WebElement state = driver.findElement ( By.id ( "state" ) );
        Select select = new Select ( state );
        select.selectByValue ( "MD" );
        BrowserUtils.wait ( 2 );
        Assert.assertEquals ( select.getFirstSelectedOption ().getText (),"Maryland" );

    }

    @AfterMethod
    public void tearDown ( ) {
        driver.quit ();
    }
}

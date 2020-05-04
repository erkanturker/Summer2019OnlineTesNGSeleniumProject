package tests.day07;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class Task03TestNGPractice {

    @Test
    public void test(){
        Assert.assertEquals ( "apple","apple","Word is not correct");

    }

    @Test(description = "Verifiying the title is on the page")
    public void verifyTitle(){
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/" );
        String expectedTitle="Practice";
        String actualTitle=driver.getTitle ();
        Assert.assertEquals ( expectedTitle,actualTitle,"Title is wrong" );
        driver.quit ();
    }

    //lets verify that Test Automation Practice heading is displayed
    @Test(description = "verify that heading is displayed")
    public void verifyingHeadingIsDisplayed(){
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/" );
        //if there is no element with this locator, we will get noSuchElementException
        //our program will top on the findElement line
        WebElement heading = driver.findElement ( By.xpath ("//span[text()='Test Automation Practice']") );
        //to make sure htat element is visible to user
        // because element can be present, but not visible
        //we need to make sure the element is visible
        //AssterTrue  method that checks if somethng is true
        //.isDisplayed return true or false
        //if it returns true that means element is visible
        //if return false hat means elements is not visible
        Assert.assertTrue ( heading.isDisplayed (),"Element is not Visible" );
        driver.quit ();
    }
}

package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Task02ActionsClassHoverPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup ( ) {
        driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/hovers" );
    }

    @Test(description = "verfiy first image")
    public void test1 ( ) {

        //create an action class to perform actions (Drag and drop context click or hover
        Actions actions = new Actions ( driver );
        WebElement image1 = driver.findElement ( By.cssSelector ( ".figure:nth-of-type(1)" ) );
        // just to hover on element not click
        //build is requered when we have more than 1 actions in a chain
        actions.moveToElement ( image1 ).perform ();

        BrowserUtils.wait ( 3 );

        WebElement textofImage = driver.findElement ( By.cssSelector ( ".figure:nth-of-type(1) h5" ) );
        String expectedText = "name: user1";
        String actualText = textofImage.getText ();
        System.out.println ( actualText );
        Assert.assertEquals ( actualText, expectedText, "Texts are different" );


    }

    @Test(description = "very all images")
    public void test2 ( ) {
        Actions actions = new Actions ( driver );
        for (int i = 1; i <= 3; i++) {
            WebElement textofImage = driver.findElement ( By.cssSelector ( ".figure:nth-of-type(" + i + ")" ) );
            actions.moveToElement ( textofImage ).perform ();
            BrowserUtils.wait ( 2 );
            String expectedText = "name: user" + i;
            String actualText =  driver.findElement ( By.cssSelector ( ".figure:nth-of-type(" + i + ") h5" ) ).getText ();
            System.out.println ( actualText );
            Assert.assertEquals ( actualText, expectedText, "Texts are different" );
        }

    }

    @AfterMethod
    public void tearDown ( ) {
        driver.close ();
    }
}

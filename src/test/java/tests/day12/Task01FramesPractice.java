package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Task01FramesPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup ( ) {
        driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/frames" );
    }

    @Test(description = "Iframe Example")
    public void test1 ( ) {

        driver.findElement ( By.linkText ( "iFrame" ) ).click ();
        // we can swithc to frame based on id name index (Starting from 0 )Web element
        driver.switchTo ().frame ( "mce_0_ifr" );
        //we found input area with following code
        WebElement inputArea = driver.findElement ( By.id ( "tinymce" ) );
        String actualMessage = inputArea.getText ();
        String expectedMessage = "Your content goes here.";

        Assert.assertEquals ( actualMessage, expectedMessage, "The message is drifferent " );

        BrowserUtils.wait ( 2 );

        inputArea.clear (); // to delete text

        BrowserUtils.wait ( 2 );
        inputArea.sendKeys ( "Java is fun" );

        //to exit from the frame
        driver.switchTo ().defaultContent ();
    }
    @Test(description = "Nested frame")
    public void test(){
        //in case nested frames
        //We must switcth to first frame then again another frame
        //html>frame 1 >frame 2
        driver.findElement ( By.linkText ( "Nested Frames" ) ).click ();
        driver.switchTo ().frame (driver.findElement(By.cssSelector ( "[name='frame-bottom']" )) );
        WebElement content = driver.findElement ( By.tagName ( "body" ) );
        System.out.println (content.getText ());



        driver.switchTo ().defaultContent (); // to exit all frames come back to origin one
        driver.switchTo ().frame ( "frame-top" );
        driver.switchTo ().frame ( "frame-left" );
        System.out.println (driver.findElement ( By.tagName ("body" )).getText ());
    }


    @AfterMethod
    public void tearDown ( ) {
        driver.close ();
    }
}

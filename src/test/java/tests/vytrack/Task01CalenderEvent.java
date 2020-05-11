package tests.vytrack;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class Task01CalenderEvent {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup ( ) {
        driver = BrowserFactory.getDriver ( "chrome" );
        //expilicit wait
        wait = new WebDriverWait ( driver, 20 );
        //implicit wait
        driver.manage ().timeouts ().implicitlyWait ( 20, TimeUnit.SECONDS );
        //maximize browser
        driver.manage ().window ().maximize ();


        driver.get ( "https://qa1.vytrack.com/user/login" );
        driver.findElement ( By.id ( "prependedInput" ) ).sendKeys ( "storemanager85" );
        driver.findElement ( By.id ( "prependedInput2" ) ).sendKeys ( "UserUser123", Keys.ENTER );

        WebElement loaderMask = driver.findElement ( By.cssSelector ( "div[class='loader-mask shown']" ) );
        wait.until ( ExpectedConditions.invisibilityOf ( loaderMask ) );

        WebElement activitiesElement = driver.findElement ( By.linkText ( "Activities" ) );
        wait.until ( ExpectedConditions.visibilityOf ( activitiesElement ) );
        wait.until ( ExpectedConditions.elementToBeClickable ( activitiesElement ) );
        activitiesElement.click ();

        WebElement calendarElement = driver.findElement ( By.linkText ( "Calendar Events" ) );
        wait.until ( ExpectedConditions.visibilityOf ( calendarElement ) );
        wait.until ( ExpectedConditions.elementToBeClickable ( calendarElement ) );
        calendarElement.click ();

        WebElement loaderMask1 = driver.findElement ( By.cssSelector ( "div[class='loader-mask shown']" ) );
        wait.until ( ExpectedConditions.invisibilityOf ( loaderMask ) );


    }

    @Test(description = "Verfiy page Subtitle")
    public void test1 ( ) {
        WebElement loaderMask = driver.findElement ( By.cssSelector ( "div[class='loader-mask shown']" ) );
        wait.until ( ExpectedConditions.invisibilityOf ( loaderMask ) );
        String ExpectedSubtitle = "All Calendar Events";
        String actualSubtitle = driver.findElement ( By.className ( "oro-subtitle" ) ).getText ();
        Assert.assertEquals ( actualSubtitle, ExpectedSubtitle, "The Message is wrong" );
    }
    @Test(description = "verify that Create Calendar Event button is Display")
    public void test2(){
       Assert.assertTrue ( driver.findElement ( By.cssSelector ( "[title='Create Calendar event']" ) ).isEnabled (),"the button is not visble" );

    }

    @AfterMethod
    public void tearDown ( ) {
        driver.close ();
    }


}

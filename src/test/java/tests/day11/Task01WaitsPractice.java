package tests.day11;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Task01WaitsPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setup ( ) {
        driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/" );
    }

    @Test
    public void test1 ( ) {
        //this line should be before all findelement() method
        // to wait within 10 second element,is present
        // We apply it once and it always work
        //put this line into @beforeMethod it will work for all tests

        driver.manage ().timeouts ().implicitlyWait ( 10, TimeUnit.SECONDS );

        driver.findElement ( By.linkText ( "Dynamic Loading" ) ).click ();
        //partialLinkTest we match only part of the link text
        //partialLinkText it's like contains text
        //Example Elemt on the page that is rendered after the rigger -- link text
        // //Example 2 only part of the link text
        //We can use partial link text locator to find element by partial text
        //

        driver.findElement ( By.partialLinkText ( "Example 2" ) ).click (); //xpath //a

        driver.findElement ( By.tagName ( "button" ) ).click ();

        WebElement finishElement = driver.findElement ( By.id ( "finish" ) );

        System.out.println ( finishElement.getText () );

    }

    @Test
    public void test2 ( ) {
        driver.findElement ( By.linkText ( "Dynamic Loading" ) ).click ();
        driver.findElement ( By.partialLinkText ( "Example 1" ) ).click ();
        driver.findElement ( By.tagName ( "button" ) ).click ();
        //Enter username
        //Explicit wait
        //we find element first
        //but the problem is element can be present but not visible

        WebDriverWait wait = new WebDriverWait ( driver, 10 );
        //We create the object of WebdriverWait to apply explicit way
        //we must provide webdriver object and period of time
        //Within this period of thime Selenium will check every 500 milliseconds
        //if condition is true and met no need to wait longer
        //your script will continue executing
        //how to aply contiditon
        WebElement userNameInputbox = driver.findElement ( By.id ( "username" ) );
        //how to applt conditions \ Expectedcontidions.condition
        //if the wait timeout time expire your test will fail
        wait.until ( ExpectedConditions.visibilityOf ( userNameInputbox ) );
        userNameInputbox.sendKeys ( "tomsmith" );
        WebElement passwordInputbox = driver.findElement ( By.id ( "pwd" ) );
        wait.until ( ExpectedConditions.visibilityOf ( passwordInputbox ) );
        passwordInputbox.sendKeys ( "SuperSecretPassword" );

        WebElement submit = driver.findElement ( By.cssSelector ( "button[type='submit']" ) );
        wait.until ( ExpectedConditions.elementToBeClickable ( submit ) );
        submit.click ();

        WebElement message = driver.findElement ( By.tagName ( "h4" ) );
        wait.until ( ExpectedConditions.visibilityOf ( message ) );

        String expectedmessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText ();
        Assert.assertEquals ( expectedmessage, actualMessage, "The message is Wrong" );


    }

    @Test
    public void test3(){
        driver.findElement ( By.linkText ( "Dynamic Loading" ) ).click ();
        driver.findElement ( By.partialLinkText ( "Example 5" ) ).click ();
        WebDriverWait wait = new WebDriverWait ( driver,10 );

        WebElement overlayScreen = driver.findElement ( By.cssSelector ( "[class='fa fa-cog fa-spin']" ) );
        wait.until ( ExpectedConditions.invisibilityOf ( overlayScreen ) );

        WebElement userNameInputbox = driver.findElement ( By.id ( "username" ) );
        //how to applt conditions \ Expectedcontidions.condition
        //if the wait timeout time expire your test will fail
        wait.until ( ExpectedConditions.visibilityOf ( userNameInputbox ) );
        userNameInputbox.sendKeys ( "tomsmith" );
        WebElement passwordInputbox = driver.findElement ( By.id ( "pwd" ) );
        wait.until ( ExpectedConditions.visibilityOf ( passwordInputbox ) );
        passwordInputbox.sendKeys ( "SuperSecretPassword" );

        WebElement submit = driver.findElement ( By.cssSelector ( "button[type='submit']" ) );
        wait.until ( ExpectedConditions.elementToBeClickable ( submit ) );
        submit.click ();

        WebElement message = driver.findElement ( By.tagName ( "h4" ) );
        wait.until ( ExpectedConditions.visibilityOf ( message ) );

        String expectedmessage = "Welcome to the Secure Area. When you are done click logout below.";
        String actualMessage = message.getText ();
        Assert.assertEquals ( expectedmessage, actualMessage, "The message is Wrong" );

    }
    @Test(description = "Fluent wait example")
    public void test4() {
        driver.findElement(By.linkText("Dynamic Loading")).click();

        driver.findElement(By.partialLinkText("Example 2")).click();

        driver.findElement(By.tagName("button")).click();

        Wait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotVisibleException.class);
        WebElement message = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("finish"));
            }
        });
    }



    @AfterMethod
    public void tearDown ( ) {
        driver.quit ();
    }
}

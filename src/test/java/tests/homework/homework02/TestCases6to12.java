package tests.homework.homework02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;
import utils.Driver;

public class TestCases6to12 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = BrowserFactory.getDriver("chrome");

    }
    @Test(description = "Verify that “Thank you for signing up. Click the button below to return to the home page.” message is displayed: ")
    public  void emailTest() {

        driver.get ( "https://www.tempmailaddress.com/" );
        String email = driver.findElement ( By.cssSelector ( "[id='email']" ) ).getText ();

        driver.navigate ().to ( "https://practice-cybertekschool.herokuapp.com/sign_up" );
        driver.findElement ( By.cssSelector ( "[name='full_name']" ) ).sendKeys ( "John Adam" );
        driver.findElement ( By.cssSelector ( "[name='email']" ) ).sendKeys ( email, Keys.ENTER );

        String expectedResult= "Thank you for signing up. Click the button below to return to the home page.";
        String actual= driver.findElement ( By.cssSelector ( "[name='signup_message']" ) ).getText ();

        BrowserUtils.wait ( 3 );

        Assert.assertEquals ( actual,expectedResult );
        driver.navigate ().back ();
        driver.navigate ().back ();


        BrowserUtils.wait ( 3 );


        String actualemail = driver.findElement (By.xpath ("//table[1]/tbody/tr[1]/td[1]"  )).getText ();
        String expectedEmail= " do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals ( actualemail,expectedEmail );

        String actualSubject = driver.findElement (By.xpath ("//table[1]/tbody/tr[1]/td[2]"  )).getText ();
        String expectedSubject= "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals ( actualemail,expectedEmail );











    }

    @Test
    public void testCase7(){
        driver.navigate ().to ( "https://practice-cybertekschool.herokuapp.com/" );
        driver.findElement ( By.partialLinkText ( "File Upload" ) ).click ();

        driver.findElement ( By.cssSelector ( "input[id='file-upload']" ) ).sendKeys ( "/Users/turker/Desktop/ClassNotes/SQL/day01SqlIntro/Day01 Class Note.txt" );
        driver.findElement ( By. cssSelector ( "input[id='file-submit']" )).click ();

        String actualResult= driver.findElement ( By.cssSelector ( "[id='uploaded-files']" ) ).getText ();
        String expectedResult= "Day01 Class Note.txt";

        Assert.assertEquals ( actualResult, expectedResult);

    }

    @Test
    public void testCase8(){
        driver.navigate ().to ( "https://practice-cybertekschool.herokuapp.com/" );
        driver.findElement ( By.partialLinkText ( "Autocomplete" ) ).click ();
        driver.findElement ( By.cssSelector ( "input[id='myCountry']" ) ).sendKeys ( "United States of America" );
        driver.findElement ( By.cssSelector ( "input[type='button']" ) ).click ();
        BrowserUtils.wait ( 2 );
        String expectedResult="You selected: United States of America";
        String actualResult=driver.findElement ( By.cssSelector ( "[id='result']" ) ).getText ();

        Assert.assertEquals ( actualResult,expectedResult );


    }

    @Test
    public void testCase9(){
        driver.navigate ().to ( "https://practice-cybertekschool.herokuapp.com/" );
        driver.findElement ( By.partialLinkText ( "Status Code" ) ).click ();
        driver.findElement ( By.partialLinkText ( "200" ) ).click ();

        String expectedResult= "This page returned a 200 status code";
        String actualResult= driver.findElement ( By.xpath ( "//*[contains(text(), 'This page')]" ) ).getText ();
        actualResult=actualResult.trim ();
        actualResult=actualResult.substring ( 0,actualResult.indexOf ( "." ) );
        Assert.assertEquals ( actualResult,expectedResult );

    }
    @Test
    public void testCase10(){
        driver.navigate ().to ( "https://practice-cybertekschool.herokuapp.com/" );
        driver.findElement ( By.partialLinkText ( "Status Code" ) ).click ();
        driver.findElement ( By.partialLinkText ( "301" ) ).click ();

        String expectedResult= "This page returned a 301 status code";
        String actualResult= driver.findElement ( By.xpath ( "//*[contains(text(), 'This page')]" ) ).getText ();
        actualResult=actualResult.trim ();
        actualResult=actualResult.substring ( 0,actualResult.indexOf ( "." ) );
        Assert.assertEquals ( actualResult,expectedResult );

    }
    @Test
    public void testCase11(){
        driver.navigate ().to ( "https://practice-cybertekschool.herokuapp.com/" );
        driver.findElement ( By.partialLinkText ( "Status Code" ) ).click ();
        driver.findElement ( By.partialLinkText ( "404" ) ).click ();

        String expectedResult= "This page returned a 404 status code";
        String actualResult= driver.findElement ( By.xpath ( "//*[contains(text(), 'This page')]" ) ).getText ();
        actualResult=actualResult.trim ();
        actualResult=actualResult.substring ( 0,actualResult.indexOf ( "." ) );
        Assert.assertEquals ( actualResult,expectedResult );

    }
    @Test
    public void testCase12(){
        driver.navigate ().to ( "https://practice-cybertekschool.herokuapp.com/" );
        driver.findElement ( By.partialLinkText ( "Status Code" ) ).click ();
        driver.findElement ( By.partialLinkText ( "500" ) ).click ();

        String expectedResult= "This page returned a 500 status code";
        String actualResult= driver.findElement ( By.xpath ( "//*[contains(text(), 'This page')]" ) ).getText ();
        actualResult=actualResult.trim ();
        actualResult=actualResult.substring ( 0,actualResult.indexOf ( "." ) );
        Assert.assertEquals ( actualResult,expectedResult );

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
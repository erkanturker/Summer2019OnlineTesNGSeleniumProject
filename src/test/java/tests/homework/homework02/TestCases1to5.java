package tests.homework.homework02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BrowserUtils;
import utils.Driver;

public class TestCases1to5 {


    @BeforeMethod
    public void setup ( ) {
        Driver.get ().get ( "https://practice-cybertekschool.herokuapp.com/" );
        Driver.get ().findElement ( By.xpath ( "//a[text()='Registration Form']" ) ).click ();
    }

    @Test
    public void test1 ( ) {

        WebElement element1 = Driver.get ().findElement ( By.cssSelector ( "label[for='inlineCheckbox1']" ) );
        Assert.assertEquals ( element1.getText (), "C++" );
        WebElement element2 = Driver.get ().findElement ( By.cssSelector ( "label[for='inlineCheckbox2']" ) );
        Assert.assertEquals ( element2.getText (), "Java" );
        WebElement element3 = Driver.get ().findElement ( By.cssSelector ( "label[for='inlineCheckbox3']" ) );
        Assert.assertEquals ( element3.getText (), "JavaScript" );
    }

    @Test
    public void test2 ( ) {
        //  Driver.get ().findElement ( By.xpath ( "//a[text()='Registration Form']" ) ).click ();
        WebElement element = Driver.get ().findElement ( By.cssSelector ( "[name='birthday']" ) );
        element.sendKeys ( "wrong_dob" );
        WebElement wrongLabel = Driver.get ().findElement ( By.cssSelector ( "small[class='help-block'][data-bv-validator='date']" ) );
        String expectedResult = "The date of birth is not valid";
        String actualResult = wrongLabel.getText ();
        Assert.assertEquals ( actualResult, expectedResult );
    }

    @Test
    public void test3 ( ) {
        // Driver.get ().findElement ( By.xpath ( "//a[text()='Registration Form']" ) ).click ();
        Driver.get ().findElement ( By.cssSelector ( "[name='firstname']" ) ).sendKeys ( "a" );
        WebElement wrongLabel = Driver.get ().findElement ( By.cssSelector ( "small[class='help-block'][data-bv-validator='stringLength'][data-bv-for='firstname']" ) );
        String actualResult = wrongLabel.getText ();
        String expectedResult = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals ( actualResult, expectedResult );

    }

    @Test
    public void test4 ( ) {
        //Driver.get ().findElement ( By.xpath ( "//a[text()='Registration Form']" ) ).click ();
        Driver.get ().findElement ( By.cssSelector ( "[name='lastname']" ) ).sendKeys ( "a" );
        WebElement label = Driver.get ().findElement ( By.cssSelector ( "small[class='help-block'][data-bv-validator='stringLength'][data-bv-for='lastname']" ) );
        String actualResult = label.getText ();
        String expectedResult = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals ( actualResult, expectedResult );

    }

    @Test
    public void test5 ( ) {
        Driver.get ().findElement ( By.cssSelector ( "[name='firstname']" ) ).sendKeys ( "Joh" );
        Driver.get ().findElement ( By.cssSelector ( "[name='lastname']" ) ).sendKeys ( "Drea" );
        Driver.get ().findElement ( By.cssSelector ( "[name='username']" ) ).sendKeys ( "johndrea" );
        Driver.get ().findElement ( By.cssSelector ( "[name='email']" ) ).sendKeys ( "johndrea@gmail.com" );
        Driver.get ().findElement ( By.cssSelector ( "[name='password']" ) ).sendKeys ( "12345678990" );
        Driver.get ().findElement ( By.cssSelector ( "[name='phone']" ) ).sendKeys ( "571-000-0000" );
        Driver.get ().findElement ( By.cssSelector ( "input[type='radio' ][ value='male']" ) ).click ();
        Driver.get ().findElement ( By.cssSelector ( "[name='birthday']" ) ).sendKeys ( "12/12/1990" );

        Select select = new Select ( Driver.get ().findElement ( By.cssSelector ( "select[name='department']" ) ) );
        Select select1 = new Select ( Driver.get ().findElement ( By.cssSelector ( "select[name='job_title']" ) ) );
        select.selectByValue ( "DE" );
        select1.selectByVisibleText ( "SDET" );
        //check buttons
        for (int i = 1; i <= 3; i++) {
            Driver.get ().findElement ( By.cssSelector ( "input[id='inlineCheckbox" + i + "']" ) ).click ();
        }
        Driver.get ().findElement ( By.cssSelector ( "button[id='wooden_spoon']" ) ).click ();


        String actualREsult = Driver.get ().findElement ( By.cssSelector ( "div[class='alert alert-success']>p" ) ).getText ();
        String expectedResult="You've successfully completed registration!";
        Assert.assertEquals ( actualREsult,expectedResult );
    }


    @AfterMethod
    public void tearDown ( ) {
        Driver.close ();
    }
}

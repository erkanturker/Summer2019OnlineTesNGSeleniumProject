package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;

import java.util.List;

public class WebTablesPractice {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup ( ) {
        driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/tables" );
        //once we find this table as a web element, we can priny all text from there
        //recommended to use this wait for any elemt not only web table

        wait = new WebDriverWait ( driver, 15 );
        wait.until ( ExpectedConditions.presenceOfElementLocated ( By.id ( "table1" ) ) );
    }

    @Test(description = "Print Table 1 Data")
    public void test1 ( ) {


        WebElement table = driver.findElement ( By.id ( "table1" ) );
        System.out.println ( table.getText () );
    }

    @Test(description = "Verfiy that number of colmuns equals to 6")
    public void test2 ( ) {
        int expectedResult = 6;
        int actualColumnNumber = driver.findElements ( By.xpath ( "//table[@id='table1']//tr//th" ) ).size ();
        Assert.assertEquals ( actualColumnNumber, expectedResult, "Different number than Expected" );
    }

    @Test(description = "verify that number of rows equals  to 5")
    public void test3 ( ) {
        int actualResult = driver.findElements ( By.xpath ( "//table[@id='table1']//tr" ) ).size ();
        int expectedResult = 5;
        Assert.assertEquals ( actualResult, expectedResult );
    }

    @Test(description = "print all values from the 2nd row (excludomg table header")
    public void test4 ( ) {
        List< WebElement > webElementList = driver.findElements ( By.xpath ( "//table[@id='table1']//tbody//tr[2]/td" ) );
        for (WebElement each : webElementList) {
            System.out.println ( each.getText () );
        }
    }

    @Test(description = "print all values from the n-th row (excludomg table header")
    public void test5 ( ) {
        //it wil more dynamic when we change the according ly index number
        //if the index exceed the number it will give us empty
        //findelemets() does not return exception
        int index = 1;
        List< WebElement > webElementList = driver.findElements ( By.xpath ( "//table[@id='table1']//tbody//tr[" + index + "]/td" ) );
        for (WebElement each : webElementList) {
            System.out.println ( each.getText () );
        }
    }

    @Test(description = "verify that email in the third row equals jdoe@hotmail.com")
    public void test6 ( ) {
        int row = 3;
        int column = 3;
        WebElement cell = driver.findElement ( By.xpath ( "//table[@id='table1']//tbody//tr[" + row + "]/td[" + column + "]" ) );
        String expectedResult = "jdoe@hotmail.com";
        String actualResult = cell.getText ();
        Assert.assertEquals ( actualResult, expectedResult );

    }

    @Test(description = "get all values from email and verfiy every value contains @")
    public void test7 ( ) {
        int column = 3;
        for (int i = 1; i <= 4; i++) {
            WebElement cell = driver.findElement ( By.xpath ( "//table[@id='table1']//tbody//tr[" + i + "]/td[" + column + "]" ) );
            boolean contains = cell.getText ().contains ( "@" );
            Assert.assertTrue ( contains, "Is not contain @ all single one" );
        }

        //This is Vasyl solution

        List< WebElement > emails = driver.findElements ( By.xpath ( "//table[@id='table1']//tbody//tr/td[" + column + "]" ) );
        for (WebElement eachemail : emails) {
            System.out.println ( eachemail.getText () );
            Assert.assertTrue ( eachemail.getText ().contains ( "@" ) );
        }


    }

    @Test(description = "verify that afte click on last name values will be sorted in alphabetic order")
    public void test8 ( ) {
        WebElement clicklastname = driver.findElement ( By.xpath ( "//table[@id='table1']//thead//tr/th[1]" ) );
        clicklastname.click ();
        List< WebElement > listLastname = driver.findElements ( By.xpath ( "//table[@id='table1']//tbody//td[1]" ) );
        for (WebElement each : listLastname) {
            System.out.println ( each.getText () );

        }
        for (int i = 0; i < listLastname.size () - 1; i++) {
            Assert.assertTrue ( listLastname.get ( i ).getText ().compareTo ( listLastname.get ( i + 1 ).getText () ) < 0, "this is no" );
            //compare method if the word is starring value is less than following one it return negative accoridng Asscii Table
        }
        //valsy code
        for (int index = 0; index < listLastname.size () - 1; index++) {
            String lastname = listLastname.get ( index ).getText ();
            String followinglastname = listLastname.get ( index + 1 ).getText ();
            Assert.assertTrue ( lastname.compareTo ( followinglastname ) < 0 );

        }
    }


    @AfterMethod
    public void tearDown ( ) {
        driver.quit ();
    }

}

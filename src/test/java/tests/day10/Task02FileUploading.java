package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Task02FileUploading {
    private WebDriver driver;

    @BeforeMethod
    public void setup ( ) {
        driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/" );
    }
    @Test
    public void test1(){
        driver.findElement ( By.linkText ("File Upload") ).click ();
        driver.findElement ( By.id ( "file-upload" ) ).sendKeys ( "/Users/turker/Desktop/classnotes1" );
        driver.findElement ( By.id ("file-submit"  ) ).click ();
        //make sure we uploaded file or not
        BrowserUtils.wait ( 3 );
        String expectedfilename ="classnotes1";
        String actualFileName=driver.findElement (By.id ( "uploaded-files" )  ).getText ();
        Assert.assertEquals (expectedfilename,actualFileName  );

    }
    @AfterMethod
    public void tearDown(){
        driver.quit ();
    }
}

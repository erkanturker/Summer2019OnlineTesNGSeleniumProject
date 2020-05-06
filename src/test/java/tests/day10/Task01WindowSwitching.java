package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.Set;

public class Task01WindowSwitching {
    private WebDriver driver;
    @BeforeMethod

    public void setup(){
        driver= BrowserFactory.getDriver ( "chrome" );
        driver.get ("http://practice.cybertekschool.com/"  );
        driver.manage ().window ().maximize ();

    }


    @Test(description = "Verify that title is still Practice")
    public void test1(){
        driver.findElement ( By.linkText ("New tab") ).click ();
        BrowserUtils.wait ( 4 );
        //after 3 second later another website will be opened int the second window
        // selenium does not switch automatically to the new window
        System.out.println (driver.getTitle ());
        Assert.assertEquals ( driver.getTitle (),"Practice","Title is wrong" );

    }
    @Test(description = "Verify that user is able to see new windows")
    public void test2(){
        driver.findElement ( By.linkText ("New tab") ).click ();
        //record id of original windows
        String oldWindow= driver.getWindowHandle ();
        //after 3 second later another website will be opened int the second window
        // selenium does not switch automatically to the new window
        BrowserUtils.wait ( 4 );
        //in the selenuum every windows has an id That id class window hanlde
        // to read window handle we use a method getWindowHandle()
        //after new window was opened, we can get list of all window id's/window handle
        Set<String> windowsHandles= driver.getWindowHandles ();
        //set is also data structure like list but it does not allow duplicates
        //also you cannot easily access anyring from there 
        //there is no .get() method 
        //That's why we  need to loop through the set to read a data from thre
        //set can only store uniqe value

        for (String windowHandle:windowsHandles) {
            // if it is not an old window
            if(!windowHandle.equals ( oldWindow )){
                //swithc to taht window
                driver.switchTo ().window ( windowHandle );
            }
            
        }
        //lets verfy that tittle of new window is a fresh tab
        System.out.println (driver.getTitle ());
        Assert.assertEquals ( driver.getTitle (),"Fresh tab","Title is wrong" );

        //comeback to original window
        String pagetitle="Practice";
        for (String windowHandle:windowsHandles) {
            //keep jumping from window to window
            driver.switchTo ().window ( windowHandle );

            //once we found page title of the wondow that we neeed
            if(driver.getTitle().equals ( pagetitle )){
                //just exit stop jumping
                break;
            }


        }
        System.out.println (driver.getTitle ());
        BrowserUtils.wait ( 3 );
        
        
    }

    @AfterMethod
    public void tearDown(){
        driver.quit ();
    }
}

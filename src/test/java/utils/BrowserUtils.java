package utils;

import freemarker.template.SimpleDate;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class BrowserUtils {
    public static void wait (int seconds) {
        try {
            Thread.sleep ( 1000 * seconds );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public static void waitForStaleElement (WebElement element) {
        int y = 0;
        while (y <= 15) {
            try {
                element.isDisplayed ();
                break;
            } catch (StaleElementReferenceException e) {
                y++;
                try {
                    Thread.sleep ( 200 );
                } catch (InterruptedException ex) {
                    ex.printStackTrace ();
                }
            }
            break;
        }
    }

    /*
    Waits for the provided element to be visible on the page
    @param element
    @param timeToWaitinSee
    @return
     */
    public static WebElement waitforVisibilty (WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait ( Driver.get (), timeToWaitInSec );
        return wait.until ( ExpectedConditions.visibilityOf ( element ) );
    }

    public static void clickWithJS (WebElement element) {
        ((JavascriptExecutor) Driver.get ()).executeScript ( "arguments[0].scrollIntoView(true);", element );
        ((JavascriptExecutor) Driver.get ()).executeScript ( "arguments[0].click();", element );

    }

    /*
      Waits for the provided element to be clickable on the page
      @param element
      @param timeToWaitinSee
    @return
     */
    public static WebElement waitForClickable (WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait ( Driver.get (), timeToWaitInSec );
        return wait.until ( ExpectedConditions.elementToBeClickable ( element ) );
    }

    public static void main (String[] args) {
        System.out.println ( System.getProperty ( "user.dir" ) );
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        System.out.println (dateFormat.format ( new Date (  ) )); //it will create an object from Date class (current date) format as we declerad above

    }

    /*
    takes Screenshot
    @param name
    take a name of a test and returns a path to the screenshot takes
     */
    public static String getScreenShot (String name) {
        //name the screenshot with the current date time to avoid duplicate name
        //  String date =LocalDateTime.now ().format ( DateTimeFormatter.ofPattern ( "yyyy-MM-dd -HH:mm" ) );
        SimpleDateFormat dateFormat = new SimpleDateFormat ( "yyyy-MM-dd -HH:mm" );
        String date = dateFormat.format ( new Date () );

        //TAke screenshot      interface from selenium which takes screenshots

        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.get ();
        File source = takesScreenshot.getScreenshotAs ( OutputType.FILE );
        //full path to the screenshot location
        //user dir provide path that bleongs to project  /Users/turker/IdeaProjects/Summer2019OnlineTesNGSeleniumProject
        String target = System.getProperty ( "user.dir" ) + "/test-output/Screenshots/" + name + date + ".png";

        File finaldestionation = new File ( target );

        //save the screen shot to the path given

        try {
            FileUtils.copyFile ( source, finaldestionation );
        } catch (IOException e) {
            e.printStackTrace ();
        }

        return target;
    }




}























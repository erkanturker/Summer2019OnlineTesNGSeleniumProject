package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


}

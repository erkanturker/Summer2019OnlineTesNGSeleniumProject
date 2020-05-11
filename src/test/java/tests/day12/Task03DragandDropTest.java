package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class Task03DragandDropTest {
    @Test(description = "Drag and Drop Test")
    public void test1 ( ) {
        WebDriver driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "https://demos.telerik.com/kendo-ui/dragdrop/index" );
        driver.manage ().window ().maximize ();
            // click on accept cookies
        driver.findElement ( By.cssSelector ( "button[title='Accept Cookies']" ) ).click ();

        BrowserUtils.wait ( 2 );


        //Create an actioan object
        Actions actions = new Actions ( driver );
        // find the elements we would like to drag and drop

        WebElement moon = driver.findElement ( By.id ("draggable") );
        WebElement earth = driver.findElement ( By.id ( "droptarget" ) );
        BrowserUtils.wait ( 2 );
        actions.dragAndDrop ( moon,earth ).perform ();

        BrowserUtils.wait ( 2 );
        driver.quit ();
    }

}

package pages;
//everyting that is in common among pages
//can go here
//for exampee top menu elements dont belong to specif page
//top menu appers on every single page
//so we can keep them here

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;
import utils.Driver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    public WebElement loadermask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubtitle;
    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logoutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    public BasePage ( ) {
        //this method requires to provide webdriver object for @FindBy
        PageFactory.initElements ( Driver.get (), this );

    }
    public void waitUntilLoaderMaskDisappear() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 30);
        try {
            wait.until( ExpectedConditions.invisibilityOf ( loadermask ) );

        } catch (NoSuchElementException e) {
            System.out.println("Loader Mask not found!");
            e.printStackTrace();

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }
    /*
    This method stands for navigation in vytract app
    provide menu name, for example fleet as astring
    and submenu name for example Vehicles
    @param menu
    @param submenue

     */
/*
         WebElement invisibleElement= Driver.get ().findElement ( By.xpath ( "div[class='loader-mask shown']" ) );
         wait.until ( ExpectedConditions.invisibilityOf ( invisibleElement));
         */

    public void navigateTo (String menu, String submenu) {

        String menuLocator = "//*[normalize-space()='" + menu + "' and @class='title title-level-1']";
        String submenuLocator = "//*[normalize-space()='" + submenu + "' and @class='title title-level-2']";

        WebDriverWait wait = new WebDriverWait ( Driver.get (), 30 );
        wait.until ( ExpectedConditions.presenceOfElementLocated ( By.xpath ( menuLocator ) ) );

        WebElement menuElement = Driver.get ().findElement ( By.xpath ( menuLocator ) );
        waitUntilLoaderMaskDisappear ();
        wait.until ( ExpectedConditions.visibilityOf ( menuElement ) );
        wait.until ( ExpectedConditions.elementToBeClickable ( menuElement ) );
        menuElement.click ();

        WebElement subMenuElement = Driver.get ().findElement ( By.xpath ( submenuLocator ) );
        wait.until ( ExpectedConditions.visibilityOf ( subMenuElement ) );
        wait.until ( ExpectedConditions.elementToBeClickable ( subMenuElement ) );


        subMenuElement.click ();
        waitUntilLoaderMaskDisappear ();
    }
    /*
    Waits until loader mask (Loading bar,spinning wheel) disapears
    @return true if loader mask is gone, false if someting went wrong
     */

    public String getSubtitle ( ) {
        //any time we are verfiying page name or page subtitle, loader mask appears
        waitUntilLoaderMaskDisappear ();
        BrowserUtils.waitForStaleElement ( pageSubtitle );
        return pageSubtitle.getText ();
    }

    public String getUserName ( ) {
        waitUntilLoaderMaskDisappear ();
        BrowserUtils.waitforVisibilty ( userName, 5 );
        return userName.getText ();
    }

    public void logout ( ) {
        BrowserUtils.wait ( 2 );
        BrowserUtils.clickWithJS ( userName );
        BrowserUtils.clickWithJS ( logoutLink );
    }

    public void goToMyUser ( ) {
        waitUntilLoaderMaskDisappear ();
        BrowserUtils.waitforVisibilty ( userName, 5 ).click ();
        BrowserUtils.waitForClickable ( myUser, 5 ).click ();

    }


}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;

public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;
    @FindBy(css = "div[class='btn btn-link dropdown-toggle']")
    public WebElement elementOption;
    @FindBy(css="input[type='number']")
    public WebElement pagenumberBar;

    public CalendarEventsPage(){
        PageFactory.initElements ( Driver.get (),this );
    }

    public void clikcToCreateCalendarEvent(){
        BrowserUtils.waitforVisibilty ( createCalendarEvent,10 );
        BrowserUtils.waitForClickable ( createCalendarEvent,10);
        createCalendarEvent.click ();
    }
    public String getOptionString (){
        BrowserUtils.waitforVisibilty ( elementOption,10 );
        return elementOption.getText ();
    }
    public String getPageBumber (){
        BrowserUtils.waitforVisibilty ( elementOption,10 );
        return pagenumberBar.getAttribute ( "value" );
    }





}

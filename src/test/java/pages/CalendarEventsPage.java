package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;

public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    public CalendarEventsPage(){
        PageFactory.initElements ( Driver.get (),this );
    }

    public void clikcToCreateCalendarEvent(){
        BrowserUtils.waitforVisibilty ( createCalendarEvent,10 );
        BrowserUtils.waitForClickable ( createCalendarEvent,10);
        createCalendarEvent.click ();


    }


}

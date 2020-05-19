package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class CalendarEventsPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    public void clikcToCreateCalendarEvent(){
        BrowserUtils.waitforVisibilty ( createCalendarEvent,10 );
        BrowserUtils.waitForClickable ( createCalendarEvent,10);
        createCalendarEvent.click ();


    }
}

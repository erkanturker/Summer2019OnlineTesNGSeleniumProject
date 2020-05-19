package tests.vytrack;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.CreateCalendarEventsPage;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;

public class CreateCalendarEventTests extends TestBase {

    @Test(description = "Verify owners name is equals to setephan Haley (it works on qa1 storemanager85")
    public void test1 ( ) {
        LoginPage loginPage = new LoginPage ();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage ();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage ();
        loginPage.login ( "storemanager85", "UserUser123" );

        loginPage.navigateTo ( "Activities", "Calendar Events" );


        //lick on create event button
        calendarEventsPage.clikcToCreateCalendarEvent ();


        BrowserUtils.waitforVisibilty ( createCalendarEventsPage.owner,4 );
        String expectedOwner = " Stephan Haley";
        String actualownder = createCalendarEventsPage.owner.getText ();
        Assert.assertEquals ( actualownder,expectedOwner );


    }
}

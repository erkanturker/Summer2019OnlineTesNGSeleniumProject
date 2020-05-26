package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CreateCalendarEventsPage extends BasePage {

    @FindBy(css = "[class='select2-chosen']")
    public WebElement owner;

    public CreateCalendarEventsPage(){
        PageFactory.initElements ( Driver.get (),this );
    }


}

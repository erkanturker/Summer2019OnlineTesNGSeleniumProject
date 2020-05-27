package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class VehiclesPage extends BasePage {

    @FindBy(css = "[title='Create Car']")
    public WebElement createCarElement;
    //use this method to click on Create a Car button
    public void clickToCreateCar ( ) {
        BrowserUtils.waitforVisibilty ( createCarElement, 10 );
        BrowserUtils.waitForClickable ( createCarElement, 10 );
        createCarElement.click ();
    }


}

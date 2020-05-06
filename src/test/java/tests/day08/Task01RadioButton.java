package tests.day08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;



public class Task01RadioButton {
    private WebDriver driver;

    @BeforeMethod
    public void setup ( ) {
        driver = BrowserFactory.getDriver ( "chrome" );
        driver.get ( "http://practice.cybertekschool.com/" );
        //to go to RadioButtons page
        //by.linktext only works with <a> tag it looks for the >text< betweeen a tags
        driver.findElement ( By.linkText ( "Radio Buttons" ) ).click ();
    }

    @Test(description = "Verify Blue Button is selected")
    public void test1 ( ) {
        //find blue radio button
        WebElement blueButton = driver.findElement ( By.id ( "blue" ) );
        // lets verfy that radioa buttons is selected
        //Asserr true that buttons is selceted
        // if the buttons is selected it will return ture othervise false
        Assert.assertTrue ( blueButton.isSelected () );
    }

    @Test(description = "Verify that Red button is not selected")
    public void test2 ( ) {
        WebElement redButton = driver.findElement ( By.id ( "red" ) );
        // lets verfy that radioa buttons is not selected
        //Asserr false that buttons is selceted
        // if the buttons is selected it will return ture othervise false
        Assert.assertFalse ( redButton.isSelected () );
    }

    @Test(description = "Verify That green button is not clickable")
    public void test3 ( ) {
        WebElement greenButton = driver.findElement ( By.id ( "green" ) );
        Assert.assertFalse ( greenButton.isEnabled () );

    }

    //lets find all radio buttons and click on them one by one
    @Test(description = "Click on all radion Buttons ")
    public void test4(){
        //find all radio buttons any radio buttons will have type='radio'
        List<WebElement> radioButtons= driver.findElements (By.cssSelector ( "input[type='radio']" )  );
        for (WebElement button: radioButtons) {
            //if buttons is available and not clicked yet
                    if (button.isEnabled ()&&!button.isSelected ()){
                        //then click on it
                        button.click ();
                        System.out.println ("Button is Clicked "+button.getAttribute ( "id" ));
                    }
                    else{
                        System.out.println ("Buttons is not Clicked "+button.getAttribute ( "id" ));
                    }

            BrowserUtils.wait ( 1 );
        }

    }


    @AfterMethod
    public void tearDown ( ) {
        driver.quit ();
    }
}

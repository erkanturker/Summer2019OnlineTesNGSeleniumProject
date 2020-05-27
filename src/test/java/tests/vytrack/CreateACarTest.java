package tests.vytrack;

import org.testng.annotations.Test;
import pages.CreateCarPAge;
import pages.LoginPage;
import pages.VehiclesPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.ConfigurationReader;

public class CreateACarTest extends TestBase {
    @Test(description = "Create some Random Car")
    public void test1 ( ) {
        extentTest = extentReports.createTest ( "Create a new CAr " );

        String username = ConfigurationReader.getProperty ( "user_name" );
        String password = ConfigurationReader.getProperty ( "password" );
        LoginPage loginPage = new LoginPage ();
        loginPage.login ( username, password );
        loginPage.navigateTo ( "Fleet", "Vehicles" );


        VehiclesPage vehiclesPage = new VehiclesPage ();
        vehiclesPage.clickToCreateCar ();
        loginPage.waitUntilLoaderMaskDisappear ();

        CreateCarPAge createCarPAge = new CreateCarPAge ();

        createCarPAge.licencePlateElement.sendKeys ( "RandomHonda" );
        createCarPAge.selectTags ( "Compact" );
        createCarPAge.selectFuelType ( "Diesel" );
        createCarPAge.saveButtonElement.click ();

        extentTest.pass ( "new car was Created" );

        BrowserUtils.wait ( 4 );


    }

}

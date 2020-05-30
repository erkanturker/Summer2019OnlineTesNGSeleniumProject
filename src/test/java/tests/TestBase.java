package tests;
//this class will be a test foundation for all test classes
// we will put here only before and after parts
//in this way before and after method will be te same
//Every test class will extedn testbase class

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BrowserUtils;
import utils.ConfigurationReader;
import utils.Driver;

import java.io.IOException;

public abstract class TestBase {
    /*
 ExtentReports itself does not build any reports, but allows reporters to
 * access information, which in turn build the said reports. An example of
 * building an HTML report and adding information to ExtentX:
 * ExtentHtmlReporter html = new ExtentHtmlReporter("Extent.html");
 * ExtentXReporter extentx = new ExtentXReporter("localhost");
     */
    protected static ExtentReports extentReports;
    //The ExtentSparkReporter creates a rich standalone spark file. It allows
    protected static ExtentSparkReporter extentHtmlReporter;
    //Defines a test. You can add logs, snapshots, assign author and categories to a test and its children.
    protected static ExtentTest extentTest;

    // <parameter name="test" value="regression"></parameter>
    @BeforeTest
    @Parameters({"test", "env_url"})
    public void BeforeTest (@Optional String test, @Optional String env_url) {
        //location of report
        //it is gonna be next to target folder test-output folder
        String reportName = "report";
        if (test != null) {
            reportName = test;
        }

        String filepathHTML = System.getProperty ( "user.dir" ) + "/test-output/" + reportName + ".html";
        extentReports = new ExtentReports ();
        extentHtmlReporter = new ExtentSparkReporter ( filepathHTML );
        extentReports.attachReporter ( extentHtmlReporter );
        extentHtmlReporter.config ().setReportName ( "Vyrack Test Result" );
        //System information

        String env= ConfigurationReader.getProperty ( "url" );
        if(env_url!=null){
            env=env_url;
        }
        extentReports.setSystemInfo ( "Environment",env );
        extentReports.setSystemInfo ( "browser", ConfigurationReader.getProperty ( "browser" ) );
        extentReports.setSystemInfo ( "OS", System.getProperty ( "os.name" ) );


    }

    @AfterTest
    public void afterTest ( ) {
        //  Writes test information from the started reporters to their output view
        extentReports.flush ();
    }

    @BeforeMethod
    @Parameters("env_url")
    public void setup (@Optional String env_url) {
        String url = ConfigurationReader.getProperty ( "url" );
        if (env_url != null) {
            url = env_url;
        }
        Driver.get ().get ( url );
    }

    // * This class describes the result of a test.
    @AfterMethod
    public void tearDown (ITestResult result) {
        if (result.getStatus () == ITestResult.FAILURE) {
            extentTest.fail ( result.getName () );
            extentTest.fail ( result.getThrowable () );
            try {
                extentTest.addScreenCaptureFromPath ( BrowserUtils.getScreenShot ( result.getName () ) );
            } catch (IOException e) {
                e.printStackTrace ();
            }
        } else if (result.getStatus () == ITestResult.SKIP) {
            extentTest.skip ( "Test case was Skipped" + result.getName () );
        }
        Driver.close ();
    }


}

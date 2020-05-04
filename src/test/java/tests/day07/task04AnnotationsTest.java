package tests.day07;

import org.testng.Assert;
import org.testng.annotations.*;

public class task04AnnotationsTest {
    //runs only ines before beforeMethod and before all test
    @BeforeClass
    public void beforeClass(){
        System.out.println ("Before Class");
    }
    //runs only after aftermethod and after all test
    @AfterClass
    public void afterClass(){
        System.out.println ("After Class");
    }
    @BeforeMethod
    public void setup(){
        //some code that will be running before every test like test1,test2,test3
        //We can use method with @BeforeMethod annotation
        //runsautomaticly before every test
        System.out.println ("Before method!");

    }

    @AfterMethod
    public void tearDown(){
        System.out.println ("After Method");
    }

    @Test
    public void test1(){
        System.out.println ("Test 1");
    }
    @Test
    public void test2(){
        System.out.println ("Test 2");
        Assert.assertTrue ( 5==5 );
    }
    @Test
    public void test3(){
        System.out.println ("Test 3");
    }
}

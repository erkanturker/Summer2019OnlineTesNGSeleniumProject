package tests.day05;
/*
task open Safari Broweser

 */


import org.openqa.selenium.By;
import org.openqa.selenium.safari.SafariDriver;

public class task02 {
    public static void main (String[] args) throws InterruptedException {
        SafariDriver driver= new SafariDriver (  );
        driver.manage ().window ().fullscreen ();
        driver.get ( "http://practice.cybertekschool.com/sign_up" );
        driver.findElement ( By.name ("full_name") ).sendKeys ( "Test User" );
        driver.findElement ( By.name ( "email" ) ).sendKeys ( "test@email.com" );
        driver.findElement ( By.name ( "wooden_spoon" ) ).click ();

        Thread.sleep ( 3000 );

        driver.quit ();

    }
}

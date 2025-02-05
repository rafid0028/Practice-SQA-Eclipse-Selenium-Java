package org.SeleniumEclipseJavaPractice;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {

    public static void main(String[] args) {

        //System.setProperty("webDriver.chrome.driver", "C:\\ChromeWebdriver\\chromedriver.exe");
        //But Found and using WebDriverManager for more easier setup

        WebDriverManager.chromedriver().setup();
        //Automated WebDriverManager Initialization

        WebDriver driver = new ChromeDriver();
        //Starts the driver and opens webpage

        driver.manage().window().maximize();
        //Defines how the webpage would behave when opened

        driver.get("https://www.google.com");
        //Drives and gets the URL

        String actualTitle1 = driver.getTitle();
        //Defines a variable ActualTitle that is brought from the URL by get.title command

        String expectedTitle1 = "Google";
        //Defines a variable ExpectedTitle that has to match with the title the URL provides.

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.titleContains("Google"));
        //Explicit command to wait for getting the EXPECTED TITLE, will wait forever to get the expected title, use with caution.


        if (actualTitle1.equals(expectedTitle1)) {
            System.out.println(actualTitle1 + "\n"+"Title Matched ^_^");
        }	else {
            System.out.println("X TITLE MISMATCH -_-" + "\n" + "Expected Title - " + (expectedTitle1));
        }



        driver.manage().window().minimize();
        //trying out minimized browser window

        driver.get("https://www.facebook.com");

        String actualTitle2 = driver.getTitle();

        String expectedTitle2 = ("Google");
        //Intentionally Wrong expectedTitle for testing purpose

        System.out.println(actualTitle2);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.titleContains("Facebook"));

        if (actualTitle2.equals(expectedTitle2)) {
            System.out.println(actualTitle2 + "\n"+"Title Matched ^_^");
        }	else {
            System.out.println("X TITLE MISMATCH -_-" + "\n" + "Expected Title - " + (expectedTitle2));
            System.out.println("CHECK THE CODE");
        }


        driver.quit();



    }

}


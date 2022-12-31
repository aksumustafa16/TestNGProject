package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class I_verifyUrlNotChanged {
    public static void main(String[] args) {

        /**
         * open browser
         * go to http://practice.cybertekschool.com/forgot_password links to an external site.
         * click on Retrive password
         * verify that url did not change
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedURL = driver.getTitle();

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        String actualURL = driver.getTitle();

        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();

    }
}


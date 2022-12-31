package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class II_verifyURLChanged {
    public static void main(String[] args) {

        /**
         * Verify URL changed
         * open browser
         * go to http://practice.cybertekschool.com/forgot_password links to an external site.
         * enter any email
         * click on Retrieve password
         * verify that url changed to http://practice.cybertekschool.com/email_sent
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedURL = "http://practice.cybertekschool.com/email_sent";

        WebElement sendEmail = driver.findElement(By.name("email"));
        sendEmail.sendKeys("test@test.com");
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        String actualURL = driver.getCurrentUrl();

        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
    }
}

package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class III_verifyConfirmationMessega {
    public static void main(String[] args) {
        /**
         * Verify confirmation message
         * open browser
         * go to http://practice.cybertekschool.com/forgot_password links to an external site.
         * enter any email
         * verify that email is display in the input box
         * click on Retrieve password
         * verify that confirmation message says 'Your e-mail's been sent!'
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedMessage = "Your e-mail's been sent!";

        WebElement sendEmail = driver.findElement(By.name("email"));
        sendEmail.sendKeys("test@test.com");
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        WebElement message = driver.findElement(By.name("confirmation_message"));

        String actualMessage = message.getText();

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println(expectedMessage);
            System.out.println(actualMessage);
        }
    }
}

package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class II_nameLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Jhon Doe");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("jhondoe@test.com");
        WebElement button = driver.findElement(By.name("wooden_spoon"));
        Thread.sleep(3000);
        button.click();

        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement message = driver.findElement(By.name("signup_message"));

        String actualMessage = message.getText();

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        driver.quit();

    }
}

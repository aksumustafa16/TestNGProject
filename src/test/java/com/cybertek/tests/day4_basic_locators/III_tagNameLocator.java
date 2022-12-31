package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class III_tagNameLocator {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox = driver.findElement(By.tagName("input"));
        fullNameInputBox.sendKeys("Mark Smith");

        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mikesmith@gmail.com");

        driver.findElement(By.tagName("button")).click();

        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}

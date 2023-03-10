package com.cybertek.tests.day12_action_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void clickWithJS() {

        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
        //clicking with JavascriptExecuter
        //create js executor object

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //use executorScript
        jse.executeScript("arguments[0].click();",dropdownLink);


    }

    @Test
    public void type() {

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputbox = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String str = "Hello disable input";

        jse.executeScript("arguments[0].setAttribute('value', '" + str +"')",inputbox);


    }

    @Test
    public void scrollDownUp() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,250)");
        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0,-250)");
        }

    }
}

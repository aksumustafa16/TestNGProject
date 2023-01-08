package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radiaButton = driver.findElement(By.id("blue"));

        //get the value of type attribute
        System.out.println(radiaButton.getAttribute("type"));
        System.out.println(radiaButton.getAttribute("name"));

        //since checked attribute does not keep any value it will return true of false based on the condition
        System.out.println(radiaButton.getAttribute("checked"));



    }
}

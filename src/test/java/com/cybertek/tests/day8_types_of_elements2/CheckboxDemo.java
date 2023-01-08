package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxDemo {

    @Test
    public void test1(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.id("box1"));
        WebElement checkbox2 = driver.findElement(By.id("box2"));

        //how to verify ckeckbox is selected or not?
        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        //how verify checkbox 1 is not selected, 2 is selected
        Assert.assertFalse(checkbox1.isSelected(),"Verify checkbox1 is NOT selected");
        Assert.assertTrue(checkbox2.isSelected(),"Verify checkbox2 is NOT selected");

        //how to click checkbox1
        checkbox1.click();

        //verify checkbox again
        Assert.assertTrue(checkbox1.isSelected(),"Verify checkbox1 is NOT selected");
        Assert.assertTrue(checkbox2.isSelected(),"Verify checkbox2 is NOT selected");

        driver.quit();



    }
}

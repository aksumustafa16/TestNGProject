package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {

    @Test
    public void radioBtnTest1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
         driver.get("http://practice.cybertekschool.com/radio_buttons");
         WebElement blueRadioButton = driver.findElement(By.id("blue"));
         WebElement redRadioButton = driver.findElement(By.id("red"));

//         //how to check is radio button is selected?
//        System.out.println("blueRadioButton = " + blueRadioButton.isSelected());
//        System.out.println("redRadioButton = " + redRadioButton.isSelected());
        //Task verify blue is selected res is not selected

        Assert.assertTrue(blueRadioButton.isSelected(),"Verify Blue is selected");
        Assert.assertFalse(redRadioButton.isSelected(),"Verify Red is NOT selected");

        //how to select radio button?
        //we use click method to select radio buttons
        redRadioButton.click();

        Assert.assertFalse(blueRadioButton.isSelected(),"Verify Blue is selected");
        Assert.assertTrue(redRadioButton.isSelected(),"Verify Red is NOT selected");

        driver.quit();


    }
}

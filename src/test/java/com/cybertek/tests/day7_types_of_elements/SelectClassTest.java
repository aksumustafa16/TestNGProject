package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {
    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //First locate your dropdown just line any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));
        //create Select object byu passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //getOptions --> returns all the available options from the dropdown list
        List<WebElement> options = stateDropdown.getOptions();

        //Print size of the options
        System.out.println(options.size());

        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }
}

package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //first locate your dropdown just line any other webelement with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //second create Select object byu passing that element as a constructor
        Select stateDropdown = new Select(dropdownElement);

        //verify that first selection is Select a state
        WebElement SelectAState = stateDropdown.getFirstSelectedOption();
        Assert.assertEquals(SelectAState.getText(),"Select a State");

        //HOW TO SELECT OPTIONS FROM DROPDOWN?
        //1.SELECT USING VISIBLE TEXT
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        String expectedOption = "Virginia";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption);

        //2.SELECT USING INDEX
        Thread.sleep(2000);
        stateDropdown.selectByIndex(51);

        expectedOption = "Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption);

        //SELECT BY VALUE
        Thread.sleep(2000);
        stateDropdown.selectByValue("IL");

        expectedOption = "Illinois";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption);


        Thread.sleep(2000);
        driver.quit();
    }
}

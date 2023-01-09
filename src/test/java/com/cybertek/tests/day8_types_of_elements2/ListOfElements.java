package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //save our webelements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        System.out.println("buttons.size() = " + buttons.size());

        //verify we have 6 buttons
        Assert.assertEquals(buttons.size(), 6);

        //loop for each button, we can implement
        for (WebElement button : buttons) {
            System.out.println(button.isDisplayed());
        }

        //click on the second button from the list
        buttons.get(1).click();
    }
        @Test
        public void test2(){
            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.get("http://practice.cybertekschool.com/multiple_buttons");

            //It is not giving error for WebElements for list just giving empty list
            List<WebElement> buttons = driver.findElements(By.tagName("buttonkjdhfkldjfkdj"));
            System.out.println("buttons.size() = " + buttons.size());

            //it is giving error for Webelement
            //WebElement button = driver.findElement(By.tagName("buttonkjdhfkldjfkdj"));


        }
}

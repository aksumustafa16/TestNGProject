package com.cybertek.tests.day7_testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeAfterTests {

    @Test
    public void test1(){
        //WebDriver part

        System.out.println("This is my test 1");


        //Close browser, quit
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("BEFORE METHOD HERE");
        System.out.println("Webdriver Part");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER METHOD HERE");
        System.out.println("Driver quit");
    }
}

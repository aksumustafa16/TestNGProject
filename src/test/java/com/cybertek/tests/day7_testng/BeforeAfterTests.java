package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterTests {

    @Test
    public void test1(){
        //WebDriver part

        System.out.println("This is my test 1");


        //Close browser, quit
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }

    @Test
    public void test3(){
        System.out.println("This is my test 3");
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

    @BeforeClass
    public void setUpClass(){
        System.out.println("--BEFORE CLASS--");
        System.out.println("RUNS ONLY ONE IN THE CLASS");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("--AFTER CLASS");
        System.out.println("RUNS ONLY ONE IN THE CLASS");
        System.out.println("GENERATE REPORT");
    }
}

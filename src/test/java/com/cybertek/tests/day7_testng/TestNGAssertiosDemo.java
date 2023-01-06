package com.cybertek.tests.day7_testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertiosDemo {

    @Test
    public void test1() {
        System.out.println("First Assertion");
        Assert.assertEquals("title", "tiTle");

        System.out.println("Second Assertion");
        Assert.assertEquals(1, 1);
    }

    @Test
    public void test2(){
        System.out.println("Second test case");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test3(){
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";
        //verify that your title is starting with Cyb

        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title start with Cby");
        Assert.assertTrue(2>1);
    }

    @Test
    public void test4(){
        //verify that email contains @
        String email = "mikesmith.com";

        Assert.assertTrue(email.contains("@"),"Verify email has @ sign");

    }

    @Test
    public void test5(){
        //verify something is false
        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    }
}

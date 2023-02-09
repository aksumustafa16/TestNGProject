package com.cybertek.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected static ExtentReports report;
    //this class is used to create HTML report file
    protected static ExtentSparkReporter htmlReporter;
    //this will define a test, enables adding logs, authors, test steps
    protected static ExtentTest extentLogger;
    protected String url;

    @BeforeTest
    public void setUpTest() {
        //initialize the class
        report = new ExtentReports();
        //create a report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";

        //initialize the html reporter with report path
        htmlReporter = new ExtentSparkReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Vytrack Smmoke Test");

        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("Tester", "Cybertek Testers");
        report.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @BeforeMethod
    @Parameters("env")
    public void setUpMethod(@Optional String env) {
        System.out.println("env: " + env);

        //if env variable is null use default url
        if (env == null) {
            url = ConfigurationReader.get("url");
        } else {
            url = ConfigurationReader.get(env + "_url");
        }
        //if is not null, choose env based on value
        System.out.println(env + "_url");
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(url);

    }

    //ITestResult class describes the result of a test in TestNG
    @AfterMethod
    public void afterMethod(ITestResult result) throws InterruptedException, IOException {
        //if test failed
        if (result.getStatus() == ITestResult.FAILURE) {
            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return location of screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            //add your screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture the exception
            extentLogger.fail(result.getThrowable());

        }


        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @AfterMethod
    public void teardown() {
        //this is when the report is actually created
        report.flush();
    }
}

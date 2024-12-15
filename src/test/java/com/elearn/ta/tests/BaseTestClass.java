package com.elearn.ta.tests;

import com.elearn.ta.driver.DriverSingleton;
import com.elearn.ta.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTestClass {
    protected WebDriver driver;
    private final String URL = "https://cloud.google.com/";

    @BeforeClass
    public void setUp(){
        driver = DriverSingleton.getDriver();
        driver.get(URL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverSingleton.closeDriver();
    }
}

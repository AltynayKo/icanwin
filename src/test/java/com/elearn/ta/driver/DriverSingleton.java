package com.elearn.ta.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver==null){
            switch (System.getProperty("browser")){
                case "firefox": driver = new FirefoxDriver(); break;
                case "chrome": driver = new ChromeDriver(); break;
                default: driver = new EdgeDriver(); break;
            }
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}

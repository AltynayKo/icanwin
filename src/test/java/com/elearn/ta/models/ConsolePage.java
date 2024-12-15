package com.elearn.ta.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConsolePage extends BasePage{
    @FindBy(xpath = "//div[@class= 'page-title' and text()='Compute Engine']")
    WebElement computeEngine;
    public ConsolePage(WebDriver driver) {
        super(driver);
    }

    @Override
    BasePage openPage() {
        return null;
    }
}

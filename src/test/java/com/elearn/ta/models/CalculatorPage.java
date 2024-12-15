package com.elearn.ta.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends BasePage{
    private final String URL = "https://cloud.google.com/products/calculator";
    @FindBy (linkText = "Console")
    WebElement consoleLink;
    By btnAddToEstimatePath = By.xpath("//span[@class='UywwFc-vQzf8d' and text()='Add to estimate']");
    WebElement btnAddToEstimate;
    @FindBy(xpath = "//div[@jsaction='xuNqMd:rvlzW;ci9oed:ZXcWpf']")
    WebElement popupAddToEstimate;
    By optionComputeEnginePath = By.xpath("//div[@jsaction='xuNqMd:rvlzW;ci9oed:ZXcWpf']//h2[text()='Compute Engine']");
    WebElement optionComputeEngine;
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public ConsolePage openConsolePage(){
        consoleLink.click();
        return new ConsolePage(driver);
    }
    public CalculatorPage openAddToEstimatePopup(){
        btnAddToEstimate = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(btnAddToEstimatePath));
        btnAddToEstimate.click();
        return new CalculatorPage(driver);
    }
    public ComputeEnginePage openComputeEngineEstimationPage(){
        optionComputeEngine = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(optionComputeEnginePath));
        optionComputeEngine.click();
        return new ComputeEnginePage(driver);
    }

    @Override
    public CalculatorPage openPage() {
        driver.navigate().to(URL);
        return this;
    }
}

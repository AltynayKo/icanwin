package com.elearn.ta.models;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ComputeEnginePage extends BasePage{

    WebElement inputInstancesNumber;
    WebElement localSSDDropdown;
    WebElement machineTypeDropdown;
    WebElement gpuModelDropdown;
    WebElement commitedUsage;
    WebElement addGPUsBtn;
    WebElement spanSumResult;
    WebElement openEstimateSummaryLink;
    By shareDialog = By.linkText("Open estimate summary");
    By machineTypeDropdownPath = By.xpath("//div[@aria-labelledby='c42 c44']/../..");
    By gpuModelDropdownPath = By.xpath("//div[@aria-labelledby='c3467 c3469']/../..");
    By localSSDDropdownPath = By.xpath("//div[@aria-labelledby='c50 c52']/../..");
    By addGPUsBtnPath = By.xpath("//button[@aria-label='Add GPUs']/div");
    By spanSumResultPath = By.xpath("//span[@class='MyvX5d D0aEmf']");
    By inputInstancesNumberPath = By.xpath("//input[@jsname='YPqjbf' and @aria-labelledby='ucc-7']");
    By serviceCodeUpdated = By.xpath("//div[text()='Service cost updated']");
    By machineTypeListPath = By.xpath("//ul[@aria-label='Machine type']/li/span[2]/span[1]");
    By gpuModelListPath = By.xpath("//ul[@aria-label='GPU Model']/li/span[2]/span[1]");
    By localSSDListPath = By.xpath("//ul[@aria-label='Local SSD']/li/span[2]/span[1]");
    By pageTitlePath = By.xpath("//h1[text()='Compute Engine']");
    By shareButtonPath = By.xpath("//button[@aria-label='Open Share Estimate dialog']");
    WebElement shareButton;

    public ComputeEnginePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, driver);
    }
    public ComputeEnginePage setInstanceNumber(String value){
        inputInstancesNumber = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(inputInstancesNumberPath));
        inputInstancesNumber.clear();
        inputInstancesNumber.sendKeys(value);
        return this;
    }
    public ComputeEnginePage selectMachineType(String value){
        machineTypeDropdown = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(machineTypeDropdownPath));
        machineTypeDropdown.click();
        selectDropdownOption(machineTypeListPath, value);
        return this;
    }
    public ComputeEnginePage selectGPUModel(String value){
        gpuModelDropdown = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(gpuModelDropdownPath));
        gpuModelDropdown.click();
        selectDropdownOption(gpuModelListPath, value);
        return this;
    }
    public ComputeEnginePage selectlocalSSD(String value){
        localSSDDropdown = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(localSSDDropdownPath));
        localSSDDropdown.click();
        selectDropdownOption(localSSDListPath, value);
        return this;
    }
    public ComputeEnginePage activateAddGPUsBtn(){
        addGPUsBtn = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(addGPUsBtnPath));
        addGPUsBtn.click();
        return this;
    }
    public ComputeEnginePage selectCommitedUsage(String value){
        By commitedUsagePath = By.xpath("//label[text()='"+value+"']");

        commitedUsage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(commitedUsagePath));
        commitedUsage.click();
        return this;
    }
    public ComputeEnginePage getEstimation(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(serviceCodeUpdated));
        return this;
    }
    public String getEstimateResult(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(serviceCodeUpdated));
        spanSumResult = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(spanSumResultPath));
        return spanSumResult.getText();
    }
    public ComputeEnginePage clickShareButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2100)", "");
        shareButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(shareButtonPath));

        shareButton.click();
        return this;
    }
    public EstimatePreviewPage openEstimateSummary(){
        openEstimateSummaryLink= new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(shareDialog));
        openEstimateSummaryLink.click();
        return new EstimatePreviewPage(driver);
    }

    @Override
    public ComputeEnginePage openPage() {
        return null;
    }
    private void selectDropdownOption(By element, String option){
        List<WebElement> options = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));

        for (WebElement opt : options) {
            if (opt.getText().equalsIgnoreCase(option)) {
                opt.click();
                break;
            }
        }
    }
}

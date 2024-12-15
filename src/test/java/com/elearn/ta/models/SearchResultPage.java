package com.elearn.ta.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasePage{
    private final String URL = "https://cloud.google.com/search";
    By calculatorSearchResultPath = By.xpath ("//a[normalize-space()='Google Cloud Pricing Calculator']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, driver);
    }

    public CalculatorPage openCalculatorPage(){
        WebElement calculatorSearchResult = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(calculatorSearchResultPath));
        calculatorSearchResult.click();
        return new CalculatorPage(driver);
    }


    @Override
    public SearchResultPage openPage() {
        driver.navigate().to(URL);
        return this;
    }
}

package com.elearn.ta.models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleDrive extends BasePage{
    private final String URL = "https://cloud.google.com/";
    @FindBy(xpath = "//div[@class='qdOxv-fmcmS-yrriRe qdOxv-fmcmS-yrriRe-OWXEXe-INsAgc qdOxv-fmcmS-yrriRe-OWXEXe-di8rgd-V67aGc qdOxv-fmcmS-yrriRe-OWXEXe-SfQLQb-M1Soyc-Bz112c qdOxv-fmcmS-yrriRe-OWXEXe-SfQLQb-UbuQg-Bz112c qdOxv-fmcmS-yrriRe-OWXEXe-XpnDCe']//i[@aria-label='Search'][normalize-space()='send_spark']")
    WebElement searchBtn;
    By searchIconPath = By.xpath("//div[@class='YSM5S']");
    By inputSearchPath = By.xpath("//input[@placeholder='Search']");

    public GoogleDrive(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, driver);
    }

    public SearchResultPage performSearch(String searchCriteria){
        WebElement searchIcon = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(searchIconPath));
        searchIcon.click();
        WebElement inputSearch = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(inputSearchPath));
        inputSearch.click();
        inputSearch.sendKeys(searchCriteria + Keys.ENTER);
        return new SearchResultPage(driver);
    }

    @Override
    GoogleDrive openPage() {
        driver.navigate().to(URL);
        return new GoogleDrive(driver);
    }
}

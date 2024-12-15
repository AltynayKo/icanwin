package com.elearn.ta.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;

public class EstimatePreviewPage extends BasePage{

    @FindBy(xpath = "//div[@class='n8xu5 Nh2Phe D0aEmf']")
    WebElement totalEstCost;
    By totalEstCostPath = By.xpath("//div[@class='AJUMrc MyvX5d D0aEmf' and text()='Total estimated cost']");

    public EstimatePreviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public String totalEstimatedCost(){
        driver.switchTo().window(getWindowID());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(totalEstCostPath));
        return totalEstCost.getText();
    }
    public String getWindowID(){
        Set<String> windowsIds = driver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList(windowsIds);
        return windowsList.get(1).toString();
    }

    @Override
    EstimatePreviewPage openPage() {
        driver.navigate().to(getWindowID());
        return this;
    }
}

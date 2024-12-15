package com.elearn.ta.tests;

import com.elearn.ta.models.GoogleDrive;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GetEstimationCostDetail extends BaseTestClass{
    @Test(groups = "Sanity", description = "TC-001. Get Compute Engine Estimation Cost Detail in new tab")
    public void openCostDetails(){
        String expectedSumResult = "$558.80";
        String actualSumResult = new GoogleDrive(driver)
                .performSearch("Google Cloud Platform Pricing Calculator")
                .openCalculatorPage()
                .openAddToEstimatePopup()
                .openComputeEngineEstimationPage()
                .setInstanceNumber("4")
                .selectMachineType("n1-standard-8")
                .activateAddGPUsBtn()
                .selectGPUModel("")
                .getEstimation()
                .clickShareButton()
                .openEstimateSummary()
                .totalEstimatedCost();
        Assert.assertEquals(actualSumResult, expectedSumResult);
    }
}

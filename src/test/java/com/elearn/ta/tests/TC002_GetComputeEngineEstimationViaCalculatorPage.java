package com.elearn.ta.tests;

import com.elearn.ta.models.GoogleDrive;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_GetComputeEngineEstimationViaCalculatorPage extends BaseTestClass{
    @Test(groups = "Regression", description = "TC-001. Get Compute Engine Estimation via Calculator page")
    public void getComputeEngineEstimation(){
        String expectedSumResult = "$995.91";
        String actualSumResult = new GoogleDrive(driver)
                .performSearch("Google Cloud Platform Pricing Calculator")
                .openCalculatorPage()
                .openAddToEstimatePopup()
                .openComputeEngineEstimationPage()
                .setInstanceNumber("4")
                .activateAddGPUsBtn()
                .selectCommitedUsage("1 year")
                .getEstimateResult();
        Assert.assertEquals(actualSumResult, expectedSumResult);
    }
}

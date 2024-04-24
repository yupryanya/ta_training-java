package com.epam.training.yuliya_azovtseva.webdriver.task3.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingCalculatorTest extends BaseTest {
    @Test
    public void testEmailCostShouldMatchCalculatorCost() {
        googleCloudMainPage.openPage().searchWithMainSearchInput("Google Cloud Pricing Calculator legacy");
        googleCloudSearchResultsPage.clickSearchResultItem(0);
        String estimatedFormPrice = googleCloudPricingCalculatorPage
                .switchToTheInstancesForm()
                .setNumberOfInstances(4)
                .setOperatingSystem("Free:")
                .setProvisioningModel("Regular")
                .setMachineFamily("General purpose")
                .setSeries("N1")
                .setMachineType("n1-standard-8")
                .selectAddGPUsCheckbox()
                .setAddGpu("NVIDIA Tesla T4", 1)
                .setLocalSsd("2x375 GB")
                .setCommittedUsage("1 Year")
                .setDatacenterLocation("Frankfurt")
                .clickAddToEstimateButton()
                .getFinalPricePerMonth();
        String tempEmail = yopmailEmailGeneratorPage.generateRandomEmailInNewTab();
        googleCloudPricingCalculatorPage.clickEmailEstimateButton();
        emailEstimateFormPage.sendWithEmailOnly(tempEmail);
        yopmailMainPage.openPage().loginWithEmailCached();
        String emailPrice = yopmailMailboxPage.getGoogleLetterCost();

        assertEquals(estimatedFormPrice, emailPrice);
    }
}

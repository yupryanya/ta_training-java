package com.epam.training.yuliya_azovtseva.framework.tests;

import com.epam.training.yuliya_azovtseva.framework.model.EstimateModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PricingCalculatorTest extends BaseTest {
    public static final String SEARCH_STRING = "Google Cloud Pricing Calculator";

    EstimateModel estimate = EstimateModel.builder()
            .numberOfInstances("4")
            .operatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)")
            .provisioningModel("Regular")
            .machineFamily("General Purpose")
            .machineSeries("N1")
            .machineType("n1-standard-8")
            .gpuModel("NVIDIA Tesla V100")
            .numberOfGpus("1")
            .localSsd("2x375 GB")
            .region("Netherlands (europe-west4)")
            .commitedUse("1 year")
            .build();

    @Test
    @Tag("smoke")
    @Tag("regression")
    @DisplayName("'Cost Estimate Summary' matches with filled values")
    public void estimateSummaryShouldMatchFormInput() {
        googleCloudMainPage.openPage().searchWithMainSearchInput(SEARCH_STRING);
        googleCloudSearchResultsPage.clickSearchResultItem(0);
        cloudCalculatorWelcomePage.navigateToComputeEngine();
        cloudCalculatorPage
                .setNumberOfInstances(estimate.getNumberOfInstances())
                .setOperatingSystem(estimate.getOperatingSystem())
                .setRadioByText(estimate.getProvisioningModel())
                .setMachine(estimate.getMachineFamily(), estimate.getMachineSeries(), estimate.getMachineType())
                .setAddGpu(estimate.getGpuModel(), estimate.getNumberOfGpus())
                .setLocalSsd(estimate.getLocalSsd())
                .setDatacenterLocation(estimate.getRegion())
                .setRadioByText(estimate.getCommitedUse())
                .navigateToEstimateSummary();

        assertThat(estimateSummary.getValue("Number of Instances")).isEqualTo(estimate.getNumberOfInstances());
        assertThat(estimateSummary.getValue("Operating System / Software")).isEqualTo(estimate.getOperatingSystem());
        assertThat(estimateSummary.getValue("Number of GPUs")).isEqualTo(estimate.getNumberOfGpus());
        assertThat(estimateSummary.getValue("GPU Model")).isEqualTo(estimate.getGpuModel());
        assertThat(estimateSummary.getValue("Local SSD")).isEqualTo(estimate.getLocalSsd());
        assertThat(estimateSummary.getValue("Machine type")).contains(estimate.getMachineType());
        assertThat(estimateSummary.getValue("Committed use discount options")).isEqualTo(estimate.getCommitedUse());
        assertThat(estimateSummary.getValue("Provisioning Model")).isEqualTo(estimate.getProvisioningModel());
        assertThat(estimateSummary.getValue("Region")).isEqualTo(estimate.getRegion());
    }
}

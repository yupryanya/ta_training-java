package com.epam.training.yuliya_azovtseva.framework.tests;

import com.epam.training.yuliya_azovtseva.framework.pages.googleCloud.GoogleCloudMainPage;
import com.epam.training.yuliya_azovtseva.framework.driver.DriverSingleton;
import com.epam.training.yuliya_azovtseva.framework.pages.googleCloud.GoogleCloudSearchResultsPage;
import com.epam.training.yuliya_azovtseva.framework.pages.googleCloud.cloudCalculator.CloudCalculatorWelcomePage;
import com.epam.training.yuliya_azovtseva.framework.pages.googleCloud.cloudCalculator.CloudCalculatorPage;
import com.epam.training.yuliya_azovtseva.framework.pages.googleCloud.cloudCalculator.CostEstimateSummaryPage;
import com.epam.training.yuliya_azovtseva.framework.utils.TestListener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(TestListener.class)
public class BaseTest {
    protected static WebDriver driver;

    GoogleCloudMainPage googleCloudMainPage = new GoogleCloudMainPage(driver);
    CloudCalculatorWelcomePage cloudCalculatorWelcomePage = new CloudCalculatorWelcomePage(driver);
    GoogleCloudSearchResultsPage googleCloudSearchResultsPage = new GoogleCloudSearchResultsPage(driver);
    CloudCalculatorPage cloudCalculatorPage = new CloudCalculatorPage(driver);
    CostEstimateSummaryPage estimateSummary = new CostEstimateSummaryPage(driver);

    @BeforeAll
    static void init() {
        driver = DriverSingleton.getDriver();
    }

    @AfterAll
    static void teardown() {
        DriverSingleton.closeDriver();
    }
}
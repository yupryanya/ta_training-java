package com.epam.training.yuliya_azovtseva.framework.pages.googleCloud.cloudCalculator;

import com.epam.training.yuliya_azovtseva.webdriver.task3.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudCalculatorWelcomePage extends BasePage {
    @FindBy(xpath = "//div[h2 = 'Get started with your estimate']//button")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//div[h2 = 'Compute Engine']")
    private WebElement computeEngineButton;

    public CloudCalculatorWelcomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToComputeEngine() {
        waitAndClickElement(addToEstimateButton);
        waitAndClickElement(computeEngineButton);
    }
}

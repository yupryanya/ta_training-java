package com.epam.training.yuliya_azovtseva.webdriver.task3.page.googleCloud.cloudCalculator;

import com.epam.training.yuliya_azovtseva.webdriver.task3.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPricingCalculatorPage extends BasePage {
    @FindBy(xpath = "//input[preceding-sibling::label[contains(text(), 'Number of instances')]]")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Operating System')]")
    private WebElement operatingSystemDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'VM Class')]")
    private WebElement provisioningModelDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Machine Family')]")
    private WebElement machineFamilyDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Series')]")
    private WebElement seriesDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Instance type')]")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//md-checkbox[contains(@aria-label, 'Add GPUs')]")
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'GPU type')]")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Number of GPUs')]")
    private WebElement numberOfGPUsDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Local SSD')]")
    private WebElement localSSDDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Datacenter location')]")
    private WebElement datacenterLocationDropdown;

    @FindBy(xpath = "//md-select[contains(@aria-label, 'Committed usage')]")
    private WebElement committedUsageDropdown;

    @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')]")
    private WebElement addToEstimateButton;

    @FindBy(xpath = "//button[@id = 'Email Estimate']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//devsite-iframe/iframe")
    private WebElement mainFrame;

    @FindBy(id = "myFrame")
    private WebElement upperFrame;

    private String dropdownOptionByText = "//md-option[.//div[contains(text(), '%s')]]";

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage openPage() {
        driver.get("https://cloud.google.com/products/calculator-legacy");
        return this;
    }

    public GoogleCloudPricingCalculatorPage switchToTheInstancesForm() {
        switchToInnerFrame();
        removeFormElements("SoleTenantForm", "PersistentDiskForm");
        return this;
    }

    public GoogleCloudPricingCalculatorPage setNumberOfInstances(int value) {
        numberOfInstancesInput.sendKeys(Integer.toString(value));
        return this;
    }

    public GoogleCloudPricingCalculatorPage setOperatingSystem(String value) {
        selectDropdownOption(operatingSystemDropdown, value);
        return this;
    }

    public GoogleCloudPricingCalculatorPage setProvisioningModel(String value) {
        selectDropdownOption(provisioningModelDropdown, value);
        return this;
    }

    public GoogleCloudPricingCalculatorPage setSeries(String value) {
        selectDropdownOption(seriesDropdown, value);
        return this;
    }

    public GoogleCloudPricingCalculatorPage setMachineType(String value) {
        selectDropdownOption(machineTypeDropdown, value);
        return this;
    }

    public GoogleCloudPricingCalculatorPage setMachineFamily(String value) {
        selectDropdownOption(machineFamilyDropdown, value);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectAddGPUsCheckbox() {
        addGPUsCheckBox.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setAddGpu(String value, int number) {
        selectDropdownOption(gpuTypeDropdown, value);

        numberOfGPUsDropdown.click();
        By gpuNumberOption = By.xpath(String.format("//md-option[contains(@ng-disabled, 'minGPU') and ./div[contains(text(), '%s')]]", Integer.toString(number)));
        WebElement option = driver.findElement(gpuNumberOption);
        waitAndClickElement(option);
        return this;
    }

    public GoogleCloudPricingCalculatorPage setLocalSsd(String value) {
        selectDropdownOption(localSSDDropdown, value);
        return this;
    }

    public GoogleCloudPricingCalculatorPage setCommittedUsage(String value) {
        selectDropdownOption(committedUsageDropdown, value);
        return this;
    }

    public GoogleCloudPricingCalculatorPage setDatacenterLocation(String value) {
        selectDropdownOption(datacenterLocationDropdown, value);
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickAddToEstimateButton() {
        waitAndClickElement(addToEstimateButton);
        return this;
    }

    public EmailEstimateFormPage clickEmailEstimateButton() {
        switchToInnerFrame();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("resultBlock")));
        waitAndClickElement(emailEstimateButton);
        return new EmailEstimateFormPage(driver);
    }

    public String getFinalPricePerMonth() {
        WebElement locator = driver.findElement(By.className("cpc-cart-total"));
        return extractCost(locator.getText());
    }

    private void selectDropdownOption(WebElement dropdown, String value) {
        dropdown.click();
        WebElement option = driver.findElement(By.xpath(String.format(dropdownOptionByText, value)));
        waitAndClickElement(option);
    }

    private void removeFormElements(String... formNames) {
        for (String formName : formNames) {
            WebElement formElement = driver.findElement(By.name(formName));
            ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", formElement);
        }
    }

    public GoogleCloudPricingCalculatorPage switchToInnerFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(mainFrame));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(upperFrame));
        return this;
    }
}

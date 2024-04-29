package com.epam.training.yuliya_azovtseva.framework.pages.googleCloud.cloudCalculator;

import com.epam.training.yuliya_azovtseva.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudCalculatorPage extends BasePage {
    @FindBy(xpath = "//div[div[text() = 'Number of Instances']]/following-sibling::div//input")
    private WebElement numberOfInstancesInput;

    @FindBy(xpath = "//span[text() = 'Operating System / Software']/ancestor::div[1]")
    private WebElement operatingSystemDropdown;

    @FindBy(xpath = "//span[text() = 'Machine Family']/ancestor::div[1]")
    private WebElement machineFamilyDropdown;

    @FindBy(xpath = "//span[text() = 'Series']/ancestor::div[1]")
    private WebElement seriesDropdown;

    @FindBy(xpath = "//span[text() = 'Machine type']/ancestor::div[1]")
    private WebElement machineTypeDropdown;

    @FindBy(xpath = "//div[div[text()= 'Add GPUs']]/preceding-sibling::div")
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//span[text() = 'GPU Model']/ancestor::div[1]")
    private WebElement gpuTypeDropdown;

    @FindBy(xpath = "//span[text() = 'Number of GPUs']/ancestor::div[1]")
    private WebElement numberOfGPUsDropdown;

    @FindBy(xpath = "//span[text() = 'Local SSD']/ancestor::div[1]")
    private WebElement localSSDDropdown;

    @FindBy(xpath = "//span[text() = 'Region']/ancestor::div[1]")
    private WebElement datacenterLocationDropdown;

    @FindBy(xpath = "//span[text() = 'Share']")
    private WebElement shareButton;

    @FindBy(xpath = "//a[text() = 'Open estimate summary']")
    private WebElement openEstimateSummaryLink;

    private String dropdownOptionByText = "//span[text() = '%s']/ancestor::li[1]";

    private String radioButtonByLabelText = "//label[contains(text(), '%s')]/parent::div";

    public CloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudCalculatorPage setNumberOfInstances(String value) {
        waitForElementToBeClickable(numberOfInstancesInput);
        numberOfInstancesInput.clear();
        numberOfInstancesInput.sendKeys(value);
        return this;
    }

    public CloudCalculatorPage setOperatingSystem(String value) {
        selectDropdownOption(operatingSystemDropdown, value);
        return this;
    }

    public CloudCalculatorPage setMachineSeries(String value) {
        selectDropdownOption(seriesDropdown, value);
        return this;
    }

    public CloudCalculatorPage setMachineType(String value) {
        selectDropdownOption(machineTypeDropdown, value);
        return this;
    }

    public CloudCalculatorPage setMachine(String family, String series, String type) {
        setMachineFamily(family);
        setMachineSeries(series);
        setMachineType(type);
        return this;
    }

    public CloudCalculatorPage setMachineFamily(String value) {
        selectDropdownOption(machineFamilyDropdown, value);
        return this;
    }

    public CloudCalculatorPage setAddGpu(String value, String number) {
        addGPUsCheckBox.click();
        selectDropdownOption(gpuTypeDropdown, value);
        selectDropdownOption(numberOfGPUsDropdown, number);
        return this;
    }

    public CloudCalculatorPage setLocalSsd(String value) {
        selectDropdownOption(localSSDDropdown, value);
        return this;
    }

    public CloudCalculatorPage setDatacenterLocation(String value) {
        selectDropdownOption(datacenterLocationDropdown, value);
        return this;
    }

    public CloudCalculatorPage setRadioByText(String value) {
        WebElement option = driver.findElement(By.xpath(String.format(radioButtonByLabelText, value)));
        option.click();
        return this;
    }

    private void selectDropdownOption(WebElement dropdown, String value) {
        waitAndClickElement(dropdown);
        WebElement option = driver.findElement(By.xpath(String.format(dropdownOptionByText, value)));
        waitAndClickElement(option);
    }

    private void waitUntilCostUpdated() {
        new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                .until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//h1[@aria-label]/parent::div/*"), 5));
    }

    public CloudCalculatorPage navigateToEstimateSummary() {
        waitUntilCostUpdated();
        String originalWindow = driver.getWindowHandle();
        waitAndClickElement(shareButton);
        waitAndClickElement(openEstimateSummaryLink);
        switchToTab(originalWindow);
        return this;
    }
}

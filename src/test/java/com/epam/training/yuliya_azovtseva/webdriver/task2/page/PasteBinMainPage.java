package com.epam.training.yuliya_azovtseva.webdriver.task2.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinMainPage extends BasePage {
    private static final String URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement textInput;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationDropdown;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxDropdown;

    @FindBy(id = "postform-name")
    private WebElement titleInput;

    @FindBy(css = ".btn.-big")
    private WebElement submitButton;

    private String dropdownOptionByText = "//li[@class='select2-results__option' and text() = '%s']";

    public PasteBinMainPage(WebDriver driver) {
        super(driver);
    }

    public PasteBinMainPage openPage() {
        driver.get(URL);
        return this;
    }

    public PasteBinMainPage setPasteTitle(String value) {
        titleInput.sendKeys(value);
        return this;
    }

    public PasteBinMainPage setPasteExpiration(String value) {
        selectDropdownOption(expirationDropdown, value);
        return this;
    }

    public PasteBinMainPage setPasteText(String value) {
        textInput.sendKeys(value);
        return this;
    }

    public PasteBinMainPage setPageSyntax(String value) {
        selectDropdownOption(syntaxDropdown, value);
        return this;
    }

    public PasteBinResultPage clickSubmitButton() {
        submitButton.click();
        return new PasteBinResultPage(driver);
    }

    private void selectDropdownOption(WebElement dropdown, String value) {
        dropdown.click();
        WebElement option = driver.findElement(By.xpath(String.format(dropdownOptionByText, value)));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(option));
        option.click();
    }
}

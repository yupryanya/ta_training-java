package com.epam.training.yuliya_azovtseva.webdriver.task1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasteBinMainPage {
    private static final String URL = "https://pastebin.com/";
    private WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement textInput;
    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationDropdown;
    @FindBy(id = "postform-name")
    private WebElement nameInput;
    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    public PasteBinMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PasteBinMainPage openPage() {
        driver.get(URL);
        return this;
    }

    public PasteBinMainPage setPasteName(String value) {
        nameInput.sendKeys(value);
        return this;
    }

    public PasteBinMainPage setPasteExpiration(String value) {
        expirationDropdown.click();
        WebElement expirationOptions = driver.findElement(By.xpath(String.format("//li[contains(text(), '%s')]", value)));
        expirationOptions.click();
        return this;
    }

    public PasteBinMainPage setPasteText(String value) {
        textInput.sendKeys(value);
        return this;
    }

    public void submitButtonClick() {
        submitButton.click();
    }
}

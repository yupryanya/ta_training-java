package com.epam.training.yuliya_azovtseva.webdriver.task3.page.googleCloud.cloudCalculator;

import com.epam.training.yuliya_azovtseva.webdriver.task3.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailEstimateFormPage extends BasePage {
    @FindBy(xpath = "//input[@type = 'email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(), 'Send Email' )]")
    private WebElement sendButton;

    public EmailEstimateFormPage(WebDriver driver) {
        super(driver);
    }

    public EmailEstimateFormPage sendWithEmailOnly(String value) {
        waitForElementToBeClickable(emailInput);
        emailInput.sendKeys(value);
        waitAndClickElement(sendButton);
        return this;
    }
}

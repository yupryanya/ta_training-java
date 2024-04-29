package com.epam.training.yuliya_azovtseva.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.training.yuliya_azovtseva.framework.config.App.config;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public abstract class BasePage {
    protected WebDriver driver;
    protected final Duration WAIT_TIMEOUT_DURATION = Duration.ofSeconds(config.timeout());

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitAndClickElement(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    protected void switchToTab(String originalWindow) {
        new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                .until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}


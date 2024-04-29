package com.epam.training.yuliya_azovtseva.framework.pages.googleCloud.cloudCalculator;

import com.epam.training.yuliya_azovtseva.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CostEstimateSummaryPage extends BasePage {
    private String valueByItemText = "//span[contains(text(), '%s')]/following-sibling::span";

    public CostEstimateSummaryPage(WebDriver driver) {
        super(driver);
    }

    public String getValue(String label) {
        WebElement element = new WebDriverWait(driver, WAIT_TIMEOUT_DURATION)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(valueByItemText, label))));
        return element.getText();
    }
}

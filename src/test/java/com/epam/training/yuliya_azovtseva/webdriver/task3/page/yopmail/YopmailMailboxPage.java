package com.epam.training.yuliya_azovtseva.webdriver.task3.page.yopmail;

import com.epam.training.yuliya_azovtseva.webdriver.task3.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailMailboxPage extends BasePage {
    @FindBy(css = "h2")
    private WebElement priceEstimateText;

    @FindBy(name = "ifmail")
    private WebElement ifmail;

    @FindBy(name = "ifinbox")
    private WebElement ifinbox;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    public YopmailMailboxPage(WebDriver driver) {
        super(driver);
    }

    public String getGoogleLetterCost() {
        if (cloudLetterReceived()) {
            switchToMailBodyFrame(ifmail);
            return extractCost(priceEstimateText.getText());
        }
        return null;
    }

    private boolean cloudLetterReceived() {
        for (int i = 0; i < 10; i++) {
            if (driver.findElement(By.id("nbmail")).getText().equals("0 mail")) {
                refreshButton.click();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                return true;
            }
        }
        return false;
    }

    private void switchToMailBodyFrame(WebElement frame) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
}

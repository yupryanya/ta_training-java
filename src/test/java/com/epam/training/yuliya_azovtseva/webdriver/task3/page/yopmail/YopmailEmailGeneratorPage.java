package com.epam.training.yuliya_azovtseva.webdriver.task3.page.yopmail;

import com.epam.training.yuliya_azovtseva.webdriver.task3.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class YopmailEmailGeneratorPage extends BasePage {
    private static final String URL = "https://yopmail.com/en/email-generator";

    @FindBy(id = "geny")
    private WebElement generatedEmail;

    public YopmailEmailGeneratorPage(WebDriver driver) {
        super(driver);
    }

    public YopmailEmailGeneratorPage openPage() {
        driver.get(URL);
        return this;
    }

    public String getEmail() {
        return generatedEmail.getText();
    }

    public String generateRandomEmailInNewTab() {
        String originHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        openPage();
        String email = getEmail();
        driver.close();
        driver.switchTo().window(originHandle);
        return email;
    }
}

package com.epam.training.yuliya_azovtseva.webdriver.task3.page.yopmail;

import com.epam.training.yuliya_azovtseva.webdriver.task3.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailMainPage extends BasePage {
    private static final String URL = "https://yopmail.com/en/";

    @FindBy(id = "refreshbut")
    private WebElement loginButton;

    @FindBy(id = "login")
    private WebElement loginInput;

    public YopmailMainPage(WebDriver driver) {
        super(driver);
    }

    public YopmailMainPage openPage() {
        driver.get(URL);
        return this;
    }

    public void loginWithEmailCached() {
        loginButton.click();
    }

    public void loginWithEmail(String email) {
        loginInput.sendKeys(email);
        loginButton.click();
    }
}

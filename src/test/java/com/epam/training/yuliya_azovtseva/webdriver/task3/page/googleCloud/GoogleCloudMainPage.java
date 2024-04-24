package com.epam.training.yuliya_azovtseva.webdriver.task3.page.googleCloud;

import com.epam.training.yuliya_azovtseva.webdriver.task3.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudMainPage extends BasePage {
    private static final String URL = "https://cloud.google.com/?hl=en";

    @FindBy(xpath = "//div[div[span[text()='\uE8B6']]]")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    public GoogleCloudMainPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudMainPage openPage() {
        driver.get(URL);
        return this;
    }

    public void searchWithMainSearchInput(String value) {
        waitAndClickElement(searchIcon);
        searchInput.sendKeys(value);
        searchInput.submit();
    }
}

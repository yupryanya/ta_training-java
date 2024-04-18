package com.epam.training.yuliya_azovtseva.webdriver.task2.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasteBinResultPage extends BasePage {
    @FindBy(css = "h1")
    private WebElement pasteTitle;

    @FindBy(css = ".highlighted-code .source")
    private WebElement pasteCode;

    @FindBy(css = "a[href^='/archive/']")
    private WebElement pasteSyntax;

    public PasteBinResultPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return pasteTitle.getText();
    }

    public String getCode() {
        return pasteCode.getText();
    }

    public String getSyntax() {
        return pasteSyntax.getText();
    }
}

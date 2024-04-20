package com.epam.training.yuliya_azovtseva.webdriver.task2.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasteBinTaskTwo extends BaseTest {
    String pasteCode = """
                git config --global user.name  "New Sheriff in Town"
                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                git push origin master --force""";
    String pasteTitle = "how to gain dominance among developers";
    String pasteSyntax = "Bash";
    String pasteExpired = "10 Minutes";

    @Test
    void resultTitleShouldBeCorrect() {
        pasteBinMainPage
                .openPage()
                .setPasteText(pasteCode)
                .setPasteTitle(pasteTitle)
                .setPageSyntax(pasteSyntax)
                .setPasteExpiration(pasteExpired)
                .clickSubmitButton();

        assertEquals(pasteTitle, pasteBinResultPage.getTitle());
    }

    @Test
    void resultCodeShouldBeCorrect() {
        pasteBinMainPage
                .openPage()
                .setPasteText(pasteCode)
                .setPasteTitle(pasteTitle)
                .setPageSyntax(pasteSyntax)
                .setPasteExpiration(pasteExpired)
                .clickSubmitButton();

        assertEquals(pasteCode, pasteBinResultPage.getCode());
    }

    @Test
    void resultSyntaxShouldBeCorrect() {
        pasteBinMainPage
                .openPage()
                .setPasteText(pasteCode)
                .setPasteTitle(pasteTitle)
                .setPageSyntax(pasteSyntax)
                .setPasteExpiration(pasteExpired)
                .clickSubmitButton();

        assertEquals(pasteSyntax, pasteBinResultPage.getSyntax());
    }
}

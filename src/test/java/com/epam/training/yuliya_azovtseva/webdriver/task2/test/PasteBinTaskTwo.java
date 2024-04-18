package com.epam.training.yuliya_azovtseva.webdriver.task2.test;

import com.epam.training.yuliya_azovtseva.webdriver.task2.page.PasteBinResultPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasteBinTaskTwo extends BaseTest {
    @Test
    void resultShouldBeCorrect() {
        String pasteCode = """
                git config --global user.name  "New Sheriff in Town"
                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                git push origin master --force""";
        String pasteName = "how to gain dominance among developers";
        String pasteSyntax = "Bash";
        String pasteExpired = "10 Minutes";

        PasteBinResultPage pasteBinResultPage = pasteBinMainPage
                .openPage()
                .setPasteText(pasteCode)
                .setPasteName(pasteName)
                .setPageSyntax(pasteSyntax)
                .setPasteExpiration(pasteExpired)
                .clickSubmitButton();

        assertEquals(pasteName, pasteBinResultPage.getTitle());
        assertEquals(pasteSyntax, pasteBinResultPage.getSyntax());
        assertEquals(pasteCode, pasteBinResultPage.getCode());
    }
}

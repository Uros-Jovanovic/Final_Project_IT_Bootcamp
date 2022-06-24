package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Locale_Tests extends Basic_Test {

    @Test(priority = 10)
    public void SetLocaleToES() {

        nav_page.getLanguageButton().click();
        nav_page.getEsButton().click();
        Assert.assertTrue(nav_page.getHeader().getText().contains("Página de aterrizaje"),
                "[ERROR] - Page Header does not contain the text.");
    }

    @Test(priority = 20)
    public void SetLocaleToEN() {

        nav_page.getLanguageButton().click();
        nav_page.getEnButton().click();
        Assert.assertTrue(nav_page.getHeader().getText().contains("Landing"),
                "[ERROR] - Page Header does not contain the text.");
    }

    @Test(priority = 30)
    public void SetLocaleToCN() {

        nav_page.getLanguageButton().click();
        nav_page.getCnButton().click();
        Assert.assertTrue(nav_page.getHeader().getText().contains("首页"),
                "[ERROR] - Page Header does not contain the text.");
    }

    @Test(priority = 40)
    public void SetLocaleToFR() {

        nav_page.getLanguageButton().click();
        nav_page.getFrButton().click();
        Assert.assertTrue(nav_page.getHeader().getText().contains("Page d'atterrissage"),
                "[ERROR] - Page Header does not contain the text.");
    }
}

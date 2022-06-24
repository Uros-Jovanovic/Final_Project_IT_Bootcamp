package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Admin_Cities_Tests extends Basic_Test {

    @Test(priority = 10)
    public void VisitsTheAdminCitiesPageAndListCities() {
        nav_page.getLoginButton().click();
        login_page.getEmail().sendKeys("admin@admin.com");
        login_page.getPassword().sendKeys("12345");
        login_page.getLoginButton().click();
        nav_page.getAdminButton().click();
        nav_page.getCitiesLinkFromDropDown().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
    }

    @Test(priority = 20)
    public void ChecksInputTypesForCreateEditNewCity() {
        nav_page.getAdminButton().click();
        nav_page.getCitiesLinkFromDropDown().click();
        cities_page.getNewItemButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-card__text")));
        Assert.assertEquals(cities_page.getNameInput().getAttribute("type"), "text",
                "[ERROR] The text input field does not have a 'text' value for the type attribute");
    }

    @Test(priority = 30)
    public void CreateNewCity() {
        nav_page.getAdminButton().click();
        nav_page.getCitiesLinkFromDropDown().click();
        cities_page.getNewItemButton().click();
        cities_page.waitForEditDialogToBeVisible();
        cities_page.getNameInput().sendKeys("Uros Jovanovic's city");
        cities_page.getSaveButton().click();
        message_pop_up_page.waitForPopUpMessageSavedSuccessfullyToBeVisible();
    }

    @Test(priority = 40)
    public void EditCity() {
        nav_page.getAdminButton().click();
        nav_page.getCitiesLinkFromDropDown().click();
        cities_page.getSearchInput().sendKeys("Uros Jovanovic's city");
        cities_page.waitForRowsToAppear(1);
        cities_page.getEditButton(1).click();
        cities_page.getNameInput().click();
        cities_page.getNameInput().sendKeys(Keys.CONTROL + "a");
        cities_page.getNameInput().sendKeys("Uros Jovanovic's city Edited");
        cities_page.getSaveButton().click();
        message_pop_up_page.waitForPopUpMessageSavedSuccessfullyToBeVisible();
        Assert.assertTrue(message_pop_up_page.waitForPopUpMessageSavedSuccessfullyToBeVisible().getText().contains("Saved successfully")
                , "[ERROR] The message does not contain this message");

    }

    @Test(priority = 50)
    public void SearchCity() {
        nav_page.getAdminButton().click();
        nav_page.getCitiesLinkFromDropDown().click();
        cities_page.getSearchInput().sendKeys("Uros Jovanovic's city Edited");
        cities_page.waitForRowsToAppear(1);
        Assert.assertEquals(cities_page.getSelectedCell(1, 2).getText()
                , "Uros Jovanovic's city Edited"
                , "[ERROR] Selected cell does not contain new city's name");

    }

    @Test(priority = 60)
    public void DeleteCity() throws InterruptedException {
        nav_page.getAdminButton().click();
        nav_page.getCitiesLinkFromDropDown().click();
        cities_page.getSearchInput().sendKeys("Uros Jovanovic's city Edited");
        cities_page.waitForRowsToAppear(1);
        Assert.assertEquals(cities_page.getSelectedCell(1, 2).getText()
                , "Uros Jovanovic's city Edited"
                , "[ERROR] Selected cell does not contain new city's name");
        cities_page.getDeleteButtonFromRow(1).click();
        cities_page.getDeleteCityButton().click();
        message_pop_up_page.waitForPopUpMessageSavedSuccessfullyToBeVisible();
        message_pop_up_page.waitForPopUpMessageSavedSuccessfullyToBeVisible();
        Assert.assertTrue(message_pop_up_page.waitForPopUpMessageSavedSuccessfullyToBeVisible().getText().contains("Deleted successfully")
                , "[ERROR] The message does not contain this message");

    }
}
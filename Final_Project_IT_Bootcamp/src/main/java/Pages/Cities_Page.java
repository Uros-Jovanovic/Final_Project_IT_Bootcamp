package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cities_Page {

    private WebDriver driver;

    public Cities_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return driver
                .findElement(By.className("btnNewItem"));
    }

    public WebElement getSearchInput() {
        return driver
                .findElement(By.id("search"));
    }

    public WebElement getNameInput() {
        return this.driver.findElement(By.id("name"));
    }

    public WebElement getSaveButton() {
        return this.driver.findElement(By.className("btnSave"));
    }

    public WebElement getDeleteCityButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//div[contains(@class,'v-card__actions')]/button[2]")));
        return driver
                .findElement(By.xpath("//div[contains(@class,'v-card__actions')]/button[2]"));
    }
    public void waitForEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-card__text")));
    }

    public void waitForRowsToAppear(int rows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rows));
    }

    public WebElement getSelectedCell(int rowNumber, int columnNumber) {
        return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td["+ columnNumber + "]"));
    }

    public WebElement getEditButton(int rowNumber) {
        return this.driver.findElements(By.id("edit")).get(rowNumber - 1);
    }
    public WebElement getDeleteButtonFromRow(int rowIndex) {
        return this.driver.findElements(By.id("delete")).get(rowIndex - 1);
    }
}
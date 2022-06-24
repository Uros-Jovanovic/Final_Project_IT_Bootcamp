package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Message_Pop_Up_Page {
    private WebDriver driver;

    public Message_Pop_Up_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForPopUpMessageToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
        return driver.findElement(By.className("v-snack__content"));
    }
    public WebElement waitForPopUpTextUserDoesNotExistsToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'User does not exists')]")));
        return this.driver.findElement(By.xpath("//li[contains(text(),'User does not exists')]"));

    }
    public WebElement waitForWrongPasswordPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
        return this.driver.findElement(By.xpath("//*[contains(@class, 'v-snack__content')]/ul/li"));
    }

    public WebElement waitForEmailAlreadyExistsPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-snack__content")));
        return driver.findElement(By.xpath("//*[contains(@class,'v-snack__wrapper')]/div/ul/li"));
     }
    public WebElement waitForSignUpSuccesfulPopUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'v-card__title')]")));
        return driver.findElement(By.xpath("//*[contains(@class,'v-card__title')]"));
    }
    public WebElement waitForPopUpMessageSavedSuccessfullyToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success")));
        return this.driver.findElement(By.className("success"));
    }
}
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {

    private WebDriver driver;

    public Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmail() {
        return driver.findElement(By.id("email"));
    }
        public WebElement getPassword() {
            return driver.findElement(By.id("password"));
        }
    public WebElement getLoginButton () {
        return driver.findElement(By.xpath("//*[contains(@class, 'v-btn v-btn--contained')]"));
    }
}
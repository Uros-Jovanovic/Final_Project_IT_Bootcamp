package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Nav_Page {

    private WebDriver driver;

    public Nav_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void getHomeLink() {
        this.driver.get(driver.getCurrentUrl() + "home");
    }

    public void getAboutLink() {
        this.driver.get(driver.getCurrentUrl() + "about");
    }
    public void getMyProfileLink() {
        this.driver.get(driver.getCurrentUrl() + "profile");
    }

    public WebElement getAdminButton() {
        return this.driver
                .findElement(By.xpath("//button[contains(@class, 'btnAdmin')]"));
    }

    public WebElement getCitiesLinkFromDropDown() {
        return this.driver
                .findElement(By.linkText("Cities"));
    }

    public WebElement getUsersLinkfromDropDown() {
        return this.driver
                .findElement(By.linkText("Users"));
    }

    public WebElement getSingUpButton() {
        return this.driver
                .findElement(By.linkText("SIGN UP"));
    }

    public WebElement getLoginButton() {
        return this.driver
                .findElement(By.linkText("LOGIN"));
    }

    public WebElement getLogoutButton() {
        return this.driver
                .findElement(By.xpath("//*[contains(@class, 'hidden-sm-and-down btnLogout')]"));
    }
    public WebElement getLanguageButton() {
        return this.driver
                .findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnButton(){
        return driver
                .findElement(By.className("btnEN"));
    }

    public WebElement getEsButton(){
        return driver
                .findElement(By.className("btnES"));
    }

    public WebElement getFrButton(){
        return driver
                .findElement(By.className("btnFR"));
    }

    public WebElement getCnButton(){
        return driver
                .findElement(By.className("btnCN"));
    }

    public WebElement getHeader() {
        return this.driver.findElement(By.tagName("h1"));
    }

}
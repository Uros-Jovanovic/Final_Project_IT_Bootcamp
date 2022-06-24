package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_Tests extends Basic_Test {

    @Test(priority = 10)
    public void VisitsTheLoginPage() {

        nav_page.getLanguageButton().click();
        nav_page.getEnButton().click();
        nav_page.getLoginButton().click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain /login");
    }

    @Test(priority = 20)
    public void ChecksInputTypes() {
        nav_page.getLoginButton().click();
        Assert.assertEquals(login_page.getEmail().getAttribute("type"), "email",
                "[ERROR] The email input field does not have an 'email' value for the type attribute");
        Assert.assertEquals(login_page.getPassword().getAttribute("type"), "password",
                "[ERROR] The password input field does not have a 'password' value for the type attribute");
    }

    @Test(priority = 30)
    public void DisplaysErrorsWhenUserDoesNotExist(){
        nav_page.getLoginButton().click();
        login_page.getEmail().sendKeys("non-existing-user@gmal.com");
        login_page.getPassword().sendKeys("password123");
        login_page.getLoginButton().click();
        message_pop_up_page.waitForPopUpTextUserDoesNotExistsToBeVisible();
        Assert.assertEquals
                (message_pop_up_page.waitForPopUpTextUserDoesNotExistsToBeVisible().getText(), "User does not exists",
                        "[ERROR] The password input field does not have a 'password' value for the type attribute");
    }

    @Test(priority = 40)
    public void DisplaysErrorsWhenPasswordIsWrong() {
        nav_page.getLoginButton().click();
        login_page.getEmail().sendKeys("admin@admin.com");
        login_page.getPassword().sendKeys("password123");
        login_page.getLoginButton().click();
        message_pop_up_page.waitForWrongPasswordPopUp();
        Assert.assertEquals(message_pop_up_page.waitForWrongPasswordPopUp().getText(),
                "Wrong password", "[ERROR] Message is not visible");
    }

    @Test(priority = 50)
    public void Login() {
        nav_page.getLoginButton().click();
        login_page.getEmail().sendKeys("admin@admin.com");
        login_page.getPassword().sendKeys("12345");
        login_page.getLoginButton().click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains("/home"));
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/home")
                , "[ERROR] Page url does not contain /home");

    }

    @Test(priority = 60)
    public void Logout() {
        Assert.assertTrue(nav_page.getLogoutButton().isDisplayed()
                , "[ERROR] The logout button is not visible");
        nav_page.getLogoutButton().click();
    }
}
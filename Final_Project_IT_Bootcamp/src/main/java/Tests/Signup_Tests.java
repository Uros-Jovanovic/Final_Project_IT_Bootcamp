package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Signup_Tests extends Basic_Test {

    @Test(priority = 10)
    public void VisitsTheSignupPage() {
        nav_page.getSingUpButton().click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/signup"));

    }

    @Test(priority = 20)
    public void ChecksInputTypes() {
        nav_page.getSingUpButton().click();
        Assert.assertTrue(signup_page.getEmailInput().getAttribute("type").equals("email")
                , "[ERROR] The email input field does not have an 'email' value for the type attribute");
        Assert.assertTrue(signup_page.getPasswordInput().getAttribute("type").equals("password")
                , "[ERROR] The password input field does not have a 'password' value for the type attribute");
        Assert.assertTrue(signup_page.getConfirmPasswordInput().getAttribute("type").equals("password")
                , "[ERROR] The confirm password input field does not have a 'password' value for the type attribute");

    }

    @Test(priority = 30)
    public void DisplaysErrorsWhenUserAlreadyExists() {
        nav_page.getSingUpButton().click();
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/signup")
                , "[ERROR] The URL does not contain /signup");
        signup_page.getNameInput().sendKeys("Another User");
        signup_page.getEmailInput().sendKeys("admin@admin.com");
        signup_page.getPasswordInput().sendKeys("12345");
        signup_page.getConfirmPasswordInput().sendKeys("12345");
        signup_page.getSignMeUpButton().click();
        message_pop_up_page.waitForPopUpMessageToBeVisible();

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/signup")
                , "[ERROR] The URL doest not contain /signup");

        Assert.assertEquals(message_pop_up_page.waitForEmailAlreadyExistsPopUp().getText(),
                "E-mail already exists", "[ERROR] Message is not visible");
    }

    @Test(priority = 40)
    public void Signup(){
        nav_page.getSingUpButton().click();
        signup_page.getNameInput().sendKeys("Uros Jovanovic16");
        signup_page.getEmailInput().sendKeys("Uros.Jovanovic16@itbootcamp.rs");
        signup_page.getPasswordInput().sendKeys("12345");
        signup_page.getConfirmPasswordInput().sendKeys("12345");
        signup_page.getSignMeUpButton().click();
        message_pop_up_page.waitForSignUpSuccesfulPopUp();
        driver.findElement(By.className("btnClose")).click();
        nav_page.getLogoutButton().click();
    }
}
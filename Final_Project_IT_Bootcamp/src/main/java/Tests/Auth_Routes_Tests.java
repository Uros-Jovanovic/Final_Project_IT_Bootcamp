package Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Auth_Routes_Tests extends Basic_Test {

    @Test(priority = 10)
    public void ForbidsVisitsToHomeUrlIfNotAuthenticated() throws InterruptedException {

        nav_page.getHomeLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(this.driver.getCurrentUrl().contains("login"),
                "[ERROR] - Page URL does not contain /login route");
    }

    @Test(priority = 20)
    public void ForbidsVisitsToProfileUrlIfNotAuthenticated() {

        nav_page.getMyProfileLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain /login route");
    }
    @Test(priority = 30)
    public void ForbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {

        driver.get(baseUrl + "/admin/cities");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] - Page URL does not contain /login route" );
    }

    @Test(priority = 40)
    public void ForbidsVisitsToAdminUsersUrlIfNotAuthenticated() {

        driver.get(baseUrl + "/admin/users");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/login"));
        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] Page URL does not contain /login route");
    }
}



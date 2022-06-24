package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Basic_Test {

    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected Login_Page login_page;
    protected Nav_Page nav_page;
    protected Cities_Page cities_page;
    protected Signup_Page signup_page;
    protected Message_Pop_Up_Page message_pop_up_page;
    protected WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        login_page = new Login_Page(driver);
        nav_page = new Nav_Page(driver);
        signup_page = new Signup_Page(driver);
        cities_page = new Cities_Page(driver);
        message_pop_up_page = new Message_Pop_Up_Page(driver);
    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @AfterMethod
    public void afterMethod() {
    }
}

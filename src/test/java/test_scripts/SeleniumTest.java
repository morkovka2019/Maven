package test_scripts;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void initDriverTest() {
        driver.get("https://google.com");
        Assertions.assertTrue(driver.getCurrentUrl().contains("google"));
    }

    @Test
    public void UseDriverManager() {
        driver.get("https://google.com");
        Assertions.assertTrue(driver.getCurrentUrl().contains("google"));
    }

    @AfterAll
    public static void tearDown () {
        driver.close();
    }
}

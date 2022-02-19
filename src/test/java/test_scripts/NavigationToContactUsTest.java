package test_scripts;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyReader;

public class NavigationToContactUsTest {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        String browser = PropertyReader.BROWSER;
        switch(browser) {
            case ("chrome"): {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
            case ("firefox"): {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            default:
                throw new InvalidArgumentException("Please initialize driver: chrome or firefox");
        }
    }

    @Test
    public void navigateToContactUsTest() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        WebElement contactUsButton = driver.findElement(By.xpath("//div[@id = 'contact-link']/a"));
        if(contactUsButton.isDisplayed()) {
            contactUsButton.click();
        }
        Thread.sleep(100);
        Assertions.assertTrue(driver.getCurrentUrl().contains("contact"));
    }

    @AfterAll
    public static void tearDown () {
        driver.close();
    }
}

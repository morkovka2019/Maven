package test_scripts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class NavigationToContactUsTest extends BaseTest{

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


}

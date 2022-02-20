package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class AuthorizationPage {
    private final String pageURL = "http://automationpractice.com/index.php?controller=authentication";
    private final WebDriver driver;

    public By signInLocator = By.id("SubmitLogin");
    public By emailInputLocator = By.cssSelector("input#email");
    public By passwordInputLocator = By.xpath("//input[@id='passwd']");
    public By navigationPanelLocator = By.cssSelector("span.navigation_page");

    public By emailForCreationInputLocator = By.id("email_create");
    public By submitCreationButtonLocator = By.id("SubmitCreate");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    public AuthorizationPage open() {
        driver.navigate().to(pageURL);
        return this;
    }

    public MyAccountPage doAuthorize(String login, String password) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(login);

        WebElement passInput = driver.findElement(passwordInputLocator);
        passInput.sendKeys(password);

        WebElement signInButton = driver.findElement(signInLocator);
        signInButton.click();
        return new MyAccountPage(driver);
    }

    public CreateAnAccountPage startCreation( String email) {
        driver.findElement(emailForCreationInputLocator).sendKeys(email);
        driver.findElement(submitCreationButtonLocator).click();
        return new CreateAnAccountPage(driver);
    }

    public AuthorizationPage checkOnPage() {
        WebElement navigationPanel = driver.findElement(navigationPanelLocator);
        Assertions.assertTrue(navigationPanel.isDisplayed());
        Assertions.assertEquals("Authentication", navigationPanel.getText());
        return this;
    }

    public AuthorizationPage waitOnPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.pollingEvery(Duration.ofSeconds(3));
        wait.withTimeout(Duration.ofSeconds(30));
        wait.ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(navigationPanelLocator));
        return this;
    }
}

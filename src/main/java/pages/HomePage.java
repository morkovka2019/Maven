package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;
import java.util.NoSuchElementException;

public class HomePage {
    private final WebDriver driver;
    private final String pageURL = PropertyReader.BASEURL;

    private final By signInButton = By.className("login");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("OpenHome Page")
    public HomePage open() {
        driver.navigate().to(pageURL);
        return checkOnPage();
    }
    @Step("Click Sign In")
    public AuthorizationPage clickSignIn() {
        driver.findElement(signInButton).click();
        return new AuthorizationPage(driver);
    }

    public HomePage checkOnPage() {
        Assertions.assertEquals("My Store", driver.getTitle(), "This is not Home Page" +
                " current page is: " + driver.getCurrentUrl());
        return this;
    }

    public HomePage waitOnPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.pollingEvery(Duration.ofSeconds(3));
        wait.withTimeout(Duration.ofSeconds(30));
        wait.ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        return this;
    }


}

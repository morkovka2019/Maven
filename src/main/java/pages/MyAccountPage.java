package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
    private final WebDriver driver;
    public By accountLocator = By.cssSelector("a.account span");
    public By navigationPanelLocator = By.cssSelector("span.navigation_page");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAuthorizedAccount() {
        return driver.findElement(accountLocator).getText();
    }

    public MyAccountPage checkOnPage() {
        WebElement navigationPanel = driver.findElement(navigationPanelLocator);
        Assertions.assertTrue(navigationPanel.isDisplayed());
        Assertions.assertEquals("My Account", navigationPanel.getText());
        return this;
    }
}

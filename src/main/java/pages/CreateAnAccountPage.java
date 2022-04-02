package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.NoSuchElementException;

public class CreateAnAccountPage {
    private final String pageURL =
            "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
    private final WebDriver driver;

    public By mrRadioButtonLocator = By.id("id_gender1");
    public By mrsRadioButtonLocator = By.id("id_gender2");
//    public By mrsRadioButtonLocator = By.xpath("//*[@id='id_gender2']");
    public By firstNameLocator = By.id("customer_firstname");
    public By lastNameLocator = By.id("customer_lastname");
    public By emailLocator = By.id("email");
    public By passwordLocator = By.id("passwd");
    public By addres1Locator = By.id("address1");
    public By cityLocator = By.id("city");
    public By stateLocator = By.id("id_state");
    public By stateDefaultLocator = By.xpath("//select[@id='id_state']/option[text()='-']");
    public By stateAlaskaLocator = By.xpath("//select[@id='id_state']/option[text()='Alaska']");
    public By stateColoradoLocator = By.xpath("//select[@id='id_state']/option[text()='Colorado']");
    public By postalCodeLocator = By.id("postcode") ;
    public By mobilePhoneLocator = By.id("phone_mobile") ;
    public By assignAnAddressLocator = By.id("alias");
    public By registerButtonLocator = By.id("submitAccount");
    Logger log = LoggerFactory.getLogger(CreateAnAccountPage.class);


    public CreateAnAccountPage( WebDriver driver) {
        this.driver = driver;
    }

    public CreateAnAccountPage open() {
        driver.navigate().to(pageURL);
        return this;
    }

    @Step("Choose Gender - Mr")
    public CreateAnAccountPage chooseMrGender() {
        log.debug("Choose gender - Mr");
        driver.findElement(mrRadioButtonLocator).click();
        return this;
    }

    @Step("Choose Gender - Mrs")
    public CreateAnAccountPage chooseMrsGender() {
        log.debug("Choose gender - Mrs");
        driver.findElement(mrsRadioButtonLocator).click();
        return this;
    }

    @Step("Input first name")
    public CreateAnAccountPage inputFirstName(String firstName) {
        log.debug("Input first name: " + firstName);
        driver.findElement(firstNameLocator).sendKeys(firstName);
        return this;
    }

    @Step("Input last name")
    public CreateAnAccountPage inputLastName(String lastName)  {
        log.debug("Input last name: " + lastName);
        driver.findElement(lastNameLocator).sendKeys(lastName);
        return this;
    }

    @Step("Input password")
    public CreateAnAccountPage inputPassword(String pass)  {
        log.debug("Input password: " + pass);
        driver.findElement(passwordLocator).sendKeys(pass);
        return this;
    }

    @Step("Input Address 1")
    public CreateAnAccountPage inputAddress1(String address)  {
        log.debug("Input Address 1: " + address);
        driver.findElement(addres1Locator).sendKeys(address);
        return this;
    }

    @Step("Input city")
    public CreateAnAccountPage inputCity(String city)  {
        log.debug("Input city: " + city);
        driver.findElement(cityLocator).sendKeys(city);
        return this;
    }

    @Step("Choose state")
    public CreateAnAccountPage chooseState(String state) {
        log.debug("Input state: " + state);
        driver.findElement(stateLocator).click();
        switch (state) {
            case "Alaska": {
                driver.findElement(stateAlaskaLocator).click();
                break;
            }
            case "Colorado": {
                driver.findElement(stateColoradoLocator).click();
                break;
            }
            default:
                driver.findElement(stateDefaultLocator).click();
        }
        return this;
    }

    @Step("Input postcode")
    public CreateAnAccountPage inputPostcode (String postcode) {
        log.debug("Input postcode: " + postcode);
        driver.findElement(postalCodeLocator).sendKeys(postcode);
        return this;
    }

    @Step("Input phone")
    public CreateAnAccountPage inputPhone (String phone) {
        log.debug("Input phone: " + phone);
        driver.findElement(mobilePhoneLocator).sendKeys(phone);
        return this;
    }

    @Step("Input Address alias")
    public CreateAnAccountPage inputAddressAlias (String alias) {
        log.debug("Input Address alias: " + alias);
        driver.findElement(assignAnAddressLocator).sendKeys(alias);
        return this;
    }

    @Step("Click register button")
    public CreateAnAccountPage clickRegisterButton() {
        log.debug("Click register button");
        driver.findElement(registerButtonLocator).click();
        return this;
    }
    @Step("New user creation")
    public MyAccountPage doCreationNewUser(String gender, String firstName, String lastName, String pass,
                                           String address, String city, String state, String postcode, String phone,
                                           String alias) {
        switch(gender) {
            case "Mr": chooseMrGender();
            case "Mrs": chooseMrsGender();
        }
        inputFirstName(firstName);
        inputLastName(lastName);
        inputPassword(pass);
        inputAddress1(address);
        inputCity(city);
        chooseState(state);
        inputPostcode(postcode);
        inputPhone(phone);
        inputAddressAlias(alias);
        clickRegisterButton();
        return new MyAccountPage(driver);
    }

    public CreateAnAccountPage waitOnPage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.pollingEvery(Duration.ofSeconds(3));
        wait.withTimeout(Duration.ofSeconds(30));
        wait.ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.elementToBeClickable(mrRadioButtonLocator));
        return this;
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    public CreateAnAccountPage( WebDriver driver) {
        this.driver = driver;
    }

    public CreateAnAccountPage open() {
        driver.navigate().to(pageURL);
        return this;
    }

    public CreateAnAccountPage chooseMrGender() {
        driver.findElement(mrRadioButtonLocator).click();
        return this;
    }

    public CreateAnAccountPage chooseMrsGender() {
        driver.findElement(mrsRadioButtonLocator).click();
        return this;
    }

    public CreateAnAccountPage inputFirstName(String firstName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
        return this;
    }

    public CreateAnAccountPage inputLastName(String lastName)  {
        driver.findElement(lastNameLocator).sendKeys(lastName);
        return this;
    }

    public CreateAnAccountPage inputPassword(String pass)  {
        driver.findElement(passwordLocator).sendKeys(pass);
        return this;
    }

    public CreateAnAccountPage inputAddress1(String address)  {
        driver.findElement(addres1Locator).sendKeys(address);
        return this;
    }

    public CreateAnAccountPage inputCity(String city)  {
        driver.findElement(cityLocator).sendKeys(city);
        return this;
    }

    public CreateAnAccountPage chooseState(String state) {
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

    public CreateAnAccountPage inputPostcode (String postcode) {
        driver.findElement(postalCodeLocator).sendKeys(postcode);
        return this;
    }

    public CreateAnAccountPage inputPhone (String phone) {
        driver.findElement(mobilePhoneLocator).sendKeys(phone);
        return this;
    }

    public CreateAnAccountPage inputAddressAlias (String alias) {
        driver.findElement(assignAnAddressLocator).sendKeys(alias);
        return this;
    }

    public CreateAnAccountPage clickRegisterButton() {
        driver.findElement(registerButtonLocator).click();
        return this;
    }

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

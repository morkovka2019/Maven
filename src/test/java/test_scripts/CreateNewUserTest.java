package test_scripts;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AuthorizationPage;
import pages.CreateAnAccountPage;
import pages.HomePage;
import pages.MyAccountPage;
import utils.PropertyReader;
import utils.WebDriverUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CreateNewUserTest extends BaseTest {
    Fairy fairy = Fairy.create();
    //Create person object
    Person person = fairy.person();
    String firstName = person.getFirstName();
    String lastName = person.getLastName();
    String fullName = person.getFullName();
    String email = person.getEmail();
    String pass = person.getPassword();
    String phone = person.getTelephoneNumber();

    Logger log = LoggerFactory.getLogger(CreateNewUserTest.class);

    @AfterEach
    public void allureAttachScreenshot() {
        File screenShot = WebDriverUtils.getScreenshot(driver);
        try {
            Allure.addAttachment("New user creation test screenshot", Files.newInputStream(screenShot.toPath()));
        } catch (IOException e) {
            System.err.println("Could not attach screenshot");
        }
    }

    @DisplayName("Create new user")
    @Description("New user creation test")
    @Story("Sign Up")
    @Epic("Hillel web-site")
    @Feature("Sign Up")
    @Link("https://test.jira.com/HIL-1734")
    @Issue("HIL-1753")
    @Test
    public void createNewUserTest() {
        log.info("Start CreateNewUserTest");
        driver.get(PropertyReader.BASEURL);
        log.info("Open web-site");
        HomePage homePage = new HomePage(driver).waitOnPage();
        log.info("Navigate to the Authorization page");
        AuthorizationPage authorizationPage = homePage.clickSignIn();
        authorizationPage.checkOnPage();
        log.info("Navigate to the Create an account page");
        CreateAnAccountPage createAnAccountPage = authorizationPage.startCreation(email);
        createAnAccountPage.waitOnPage();
        log.info("Create an account");
        MyAccountPage myAccountPage = createAnAccountPage.doCreationNewUser("Mrs", firstName,
                lastName, pass, "testAddress", "Adak", "Alaska", "87995",
                phone, "testAlias");
        String account = myAccountPage.getAuthorizedAccount();
        log.info("Verify that new account is created");
        Assertions.assertEquals(fullName, account);
    }
}

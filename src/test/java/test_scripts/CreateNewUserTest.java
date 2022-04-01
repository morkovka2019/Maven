package test_scripts;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        driver.get(PropertyReader.BASEURL);
        HomePage homePage = new HomePage(driver).waitOnPage();
        AuthorizationPage authorizationPage = homePage.clickSignIn();
        authorizationPage.checkOnPage();
        CreateAnAccountPage createAnAccountPage = authorizationPage.startCreation(email);
        createAnAccountPage.waitOnPage();
        MyAccountPage myAccountPage = createAnAccountPage.doCreationNewUser("Mrs", firstName,
                lastName, pass, "testAddress", "Adak", "Alaska", "87995",
                phone, "testAlias");
        String account = myAccountPage.getAuthorizedAccount();
        Assertions.assertEquals(fullName, account);
    }
}

package test_scripts;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.AuthorizationPage;
import pages.CreateAnAccountPage;
import pages.HomePage;
import pages.MyAccountPage;
import utils.PropertyReader;

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

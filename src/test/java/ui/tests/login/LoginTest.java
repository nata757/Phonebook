package ui.tests.login;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.page.MenuEl;
import ui.page.login.LoginPage;
import ui.tests.TestBase;

public class LoginTest extends TestBase {
    String email = "test@gmail.com";
    String password = "test@gmail.com";
    LoginPage loginPage;
    MenuEl menu;
    Faker faker = new Faker();
    String wrongEmail = faker.internet().emailAddress();
    String wrongPassword = faker.internet().password();

    String errorLoginPasswordMessage = "Please check your activation or Login + Password combination";

    @Test
    public void loginTest() {
        logger.info("Test Data:\nlogin -" + email + "\npassword - " + password);
        loginPage = new LoginPage(driver);
        loginPage.getLogin(email, password);
        menu = new MenuEl(driver);

        Assert.assertTrue(menu.isAddNewContactMenuLinkDisplayed(), "The main page did not load");
    }

    @Test
    public void loginWithWrongLoginAndPassword() {
        logger.info("Test Data:\nlogin -" + wrongEmail+ "\npassword - " + wrongPassword);
        loginPage = new LoginPage(driver);
        loginPage.getLogin(wrongEmail, wrongPassword);

        Assert.assertEquals(loginPage.getErrorLoginPasswordMessage(), errorLoginPasswordMessage,
                "The error message did not match with expected text");
    }


}

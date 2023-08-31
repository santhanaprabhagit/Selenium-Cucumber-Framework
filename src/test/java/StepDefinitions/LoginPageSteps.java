package StepDefinitions;

import Managers.FileReaderManager;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import Helpers.TestContext;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class LoginPageSteps {
    TestContext testContext;
    LoginPage loginPage;
    MainPage mainPage;

    public LoginPageSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        mainPage = testContext.getPageObjectManager().getMainPage();
    }
    @Given("User is login in using {string} account")
    public void userIsLoginInUsingTestAccount(String accountType) {
        loginPage.clickLogin();
        String username = "";
        String password = "";
        if(accountType.equals("Testuser")) {
            username = FileReaderManager.getInstance().getConfigFileReader().getGUITestUserName();
            password = FileReaderManager.getInstance().getConfigFileReader().getGUITestUserPassword();
        } else {
            Assert.fail(accountType + " is not recognized user account type");
        }
        loginPage.enterLoginEmail(username);
        loginPage.enterLoginPassword(password);
        loginPage.submitUserLogin();
        Assert.assertTrue(mainPage.getLoggedInUserText().contains("Logged in"), "User is not logged in");
    }
}

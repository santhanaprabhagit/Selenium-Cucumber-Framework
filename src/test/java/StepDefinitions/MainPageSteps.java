package StepDefinitions;

import PageObjects.LoginPage;
import PageObjects.MainPage;
import Helpers.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MainPageSteps {
    TestContext testContext;
    LoginPage loginPage;
    MainPage mainPage;

    public MainPageSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        mainPage = testContext.getPageObjectManager().getMainPage();
    }
    @When("User clicks on the logout link")
    public void userClicksOnTheLogoutLink() {
        mainPage.clickLogout();
    }

    @Then("User see the login page")
    public void userSeeTheLoginPage() {
        Assert.assertTrue(loginPage.isLoginTextFieldAvailble(), "Current page is not a login page");
    }
}

package PageObjects;

import Helpers.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    private final WebDriver webDriver;
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;
        @FindBy(css = "input[name=email]")
    private WebElement inputUserEmail;
        @FindBy(css = "input[name=password]")
    private WebElement inputUserPassword;
        @FindBy(css = "button[type='submit']")
    private WebElement buttonSubmit;

    public void clickLogin()
    {
        loginLink.click();
    }
    public void enterLoginEmail(String userEmail)
    {
        inputUserEmail.sendKeys(userEmail);
    }
    public Boolean isLoginTextFieldAvailble()
    {
        Wait.untilAjaxCallIsDone(webDriver, Duration.ofSeconds(30L));
        return inputUserEmail.isEnabled();
    }
    public void enterLoginPassword(String userPassword)
    {
        inputUserPassword.sendKeys(userPassword);
    }
    public void submitUserLogin()
    {
        buttonSubmit.click();
    }

    //mycode end
}

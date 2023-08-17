package Managers;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private LoginPage loginPage;
    private MainPage mainPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //General If...Else
    public LoginPage getLoginPage() {

        if (loginPage == null) {
            loginPage = new LoginPage(webDriver);
        }
        return loginPage;
    }
    public MainPage getMainPage() {

        if (mainPage == null) {
            mainPage = new MainPage(webDriver);
        }
        return mainPage;
    }
}

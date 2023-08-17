package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MainPage {
    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }
     @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logout;
        @FindBy(xpath = "//i[contains(@class,'fa-user')]//parent::a")
    private WebElement loggedInUser;
    public void clickLogout()
    {
        logout.click();
    }
    public String getLoggedInUserText()
    {
        return loggedInUser.getAttribute("innerText");
    }
}

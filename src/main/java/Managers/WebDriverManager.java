package Managers;

import Enums.DriverType;
import Enums.EnvironmentType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    private WebDriver webDriver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case CHROME:
                /* Incase of using headless driver
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless", "--window-size=1644,868");
                webDriver = new ChromeDriver(chromeOptions);
                Headless browser code ends here*/
               /* ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                DesiredCapabilities cp = new DesiredCapabilities();
                cp.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(cp);*/
                webDriver = new ChromeDriver();

                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                webDriver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                webDriver = new EdgeDriver();
                break;
            case SAFARI:
                webDriver = new SafariDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return webDriver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("Remote web driver is not yet implemented");
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                webDriver = createLocalDriver();
                break;
            case REMOTE:
                webDriver = createRemoteDriver();
                break;
        }
        return webDriver;
    }

    public WebDriver getDriver() {
        if (webDriver == null) webDriver = createDriver();
        return webDriver;
    }

    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }
}

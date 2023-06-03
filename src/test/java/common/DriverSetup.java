package common;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Objects;

public class DriverSetup {
    public static WebDriver driver;
    String browser = System.getProperty("browser");
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;

    public void setUpDriver(){
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--log-level=3");
        chromeOptions.addArguments("--silent");
        chromeOptions.addArguments("--remote-allow-origins=*");

        edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--log-level=3");
        edgeOptions.addArguments("--silent");
        edgeOptions.addArguments("--remote-allow-origins=*");

        if(browser == "" || browser == null){
            browser = "chrome";
        }

        switch(browser) {
            case "edge":
                driver = WebDriverManager.edgedriver().capabilities(edgeOptions).create();
                break;
            case "firefox":
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
                driver = WebDriverManager.firefoxdriver().create();
                break;
            case "chrome":
                driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
                break;
        }
        driver.manage().window().maximize();
    }

    public void quitDriver(){
        if(Objects.nonNull(driver)){
            driver.quit();
        }
    }
}

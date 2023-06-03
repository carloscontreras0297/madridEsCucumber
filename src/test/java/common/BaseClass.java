package common;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class BaseClass extends DriverSetup{
    public static final int SECONDS = 20;
    private WebDriverWait wait;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(SECONDS));
    }

    protected void visitWebPage(String url) {
        driver.get(url);
    }

    protected void returnPreviousPage() {
        driver.navigate().back();
    }

    protected void navigateToPage(String url) {
        driver.navigate().to(url);
    }

    protected void switchToIframe(WebElement element){
        driver.switchTo().frame(element);
    }

    protected void switchToDefaultIframe(){
        driver.switchTo().defaultContent();
    }

    protected void waitForElementVisibility(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            Assert.fail(e.getMessage());
        }
    }

    protected void waitAndClickElement(WebElement element) {
        waitForElementVisibility(element);
        element.click();
    }

    protected void validateURL(String expectedURL) {
        Assert.assertEquals(expectedURL, driver.getCurrentUrl(), "The URL is not the same");
    }

    protected void validateText(WebElement element, String textToValidate) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(textToValidate, element.getText(), "The text is not the same");
        softAssert.assertAll();
    }

    protected void validateTextHardAssert(WebElement element, String textToValidate) {
        Assert.assertEquals(element.getAttribute("innerText"), textToValidate, "The page number is not correct");
    }

    protected void verifyIfTextIsPresentOnWebPage(List<WebElement> elements) {
        Assert.assertNotEquals(0, elements.size(), "The word is not present on the webpage");
    }

    protected void compareText(String actualText, String expectedText) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualText, expectedText, "The text is not equal or is not present");
        softAssert.assertAll();
    }

    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitTime() throws InterruptedException {
        synchronized (driver) {
            driver.wait(1500);
        }
    }
}

package stepDefinitions;

import com.github.dockerjava.api.model.Driver;
import common.BaseClass;
import common.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

public class HomePageStepsDefs extends DriverSetup {

    private HomePage homePage;

    @Before
    public void setup(){
        setUpDriver();
        this.homePage = new HomePage(driver);
    }
    @After
    public void teardown(){
        quitDriver();
    }

    @Given("Navigate to MadridES Page")
    public void navigate_to_madridES_page() throws InterruptedException{
        homePage.navigateToHomepage();
        homePage.waitTime();
    }

    @Given("A loaded MadridES Webpage on the browser")
    public void a_loaded_madridES_webpage_on_the_browser() throws InterruptedException{
        homePage.verifyHomePageUrl();
        homePage.waitTime();
    }

    @When("Click Accept Cookies")
    public void click_accept_cookies() throws InterruptedException{
        homePage.clickAcceptCookies();
        homePage.waitTime();
    }

    @Then("Verify Twitter IFrame Title")
    public void verify_twitter_iframe_title() throws InterruptedException{
        homePage.validateTwitterIframeTitle();
        homePage.waitTime();
    }
}

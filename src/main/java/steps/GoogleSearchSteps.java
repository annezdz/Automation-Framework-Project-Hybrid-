package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GoogleSearchSteps {

    WebDriver driver = null;

    @Given("browser is open")
    public void browser_is_open() {
        System.out.println("browser is open");
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    @And("user is on google search page")
    public void user_is_on_google_search_page() {
        System.out.println("user is on google search page");
        driver.navigate().to("https://www.google.com/");
    }

    @When("user enters a text in search box")
    public void user_enters_a_text_in_search_box() {
        System.out.println("user enters a text in search box");
        driver.findElement(By.name("q")).sendKeys("Automation Step by Step");
    }

    @And("hits enter")
    public void hits_enter() {
        System.out.println("hits enter");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("user is navigated to search results")
    public void user_is_navigated_to_search_results() {
        System.out.println("user is navigated to search results");
        driver.getPageSource().contains("Online Courses");
        driver.close();
        driver.quit();
    }
}

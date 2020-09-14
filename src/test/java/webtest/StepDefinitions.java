package webtest;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.assertj.core.api.Assertions.*;


public class StepDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;

    public StepDefinitions() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 10L);
    }

    @Given("{string} web site")
    public void open_web_site(String webSite) {
        System.out.println("Opening " + webSite);
        this.driver.get(webSite);
    }

    @When("search {string}")
    public void searchText(String text) {
        System.out.println("Searching: " + text);
        WebElement findElement = this.driver.findElement(By.id("twotabsearchtextbox"));
        findElement.sendKeys(text);
        findElement.sendKeys(Keys.ENTER);
        this.wait.until(elementToBeClickable(By.className("a-button-inner")));
    }

    @When("sort results from highest to slowest price")
    public void sortFromHighestToLowestPrice() {
        // Open drop down menu
        this.driver.findElement(By.className("a-button-inner")).click();
        // Click "Price: High to Low"
        this.driver.findElement(By.id("s-result-sort-select_2")).click();
    }

    @When("select second product")
    public void selectSecondProduct() {
        // Write code here that turns the phrase above into concrete actions
        By secondElementLocator = By.cssSelector("[data-index=\"1\"]");

        this.wait.until(visibilityOfElementLocated(secondElementLocator));
        this.driver
                .findElement(secondElementLocator)
                .findElement(By.className("a-link-normal"))
                .click();
    }

    @Then("product topic contains {string}")
    public void productTopicContains(String assertText) {
        // Write code here that turns the phrase above into concrete actions
        By productTitleLocator = By.id("productTitle");
        this.wait.until(visibilityOfElementLocated(productTitleLocator));
        assertThat(this.driver.findElement(productTitleLocator).getText())
                .contains(assertText);
    }

    @After
    public void tidyUp() {
        this.driver.quit();
    }

}

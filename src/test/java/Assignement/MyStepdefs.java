package Assignement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;
    @Given("Open the Webdriver")
    public void openTheWebdriver() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }

    @When("Enter the {string} URL")
    public void enterTheSpecifiedURL(String data) {
        driver.get(data);
        driver.manage().window().maximize();

    }


    @Then("page is Displayed")
    public void pageIsDisplayed() {
        String str=driver.getTitle();
        Assert.assertEquals(str,"Kohl's | Shop Clothing, Shoes, Home, Kitchen, Bedding, Toys & More");
        System.out.println(str);

    }


    @Then("Wait for page to load")
    public void waitForPageToLoad() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("Enter the {string} in the value")
    public void enterTheSearchInTheValue(String search) {
        driver.findElement(By.id("search")).sendKeys(search);


    }

    @And("click enter")
    public void clickEnter() {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();

    }


    @When("Page is loaded")
    public void pageIsLoaded() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Then("Scroll Down")
    public void scrollDown() {
        Actions act = new Actions(driver);
        WebElement s=driver.findElement(By.className("result_count"));
        ////*[@id="root_panel5886899"]/div[1]/span[1]
        act.moveToElement(s);

    }

    @And("click on SortBy button")
    public void clickOnSortByButton() {
        driver.findElement(By.linkText("Featured")).click();
    }

    @Then("Select {string}")
    public void selectOne(String str) {
        WebElement dropdown = driver.findElement(By.className("sbOptions"));
        List<WebElement> list = dropdown.findElements(By.tagName("li"));

        for (WebElement webElement : list) {
            String searchText = webElement.getText();

            if (searchText.equalsIgnoreCase(str)) {
                webElement.click();
                break;
            }
        }


    }

    @And("Press enter")
    public void PressEnter() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement selectResult = driver.findElement(By.className("products"));
        List<WebElement> listSort = selectResult.findElements(By.className("products_grid"));
        for (int i = 0; i < listSort.size(); i++) {
            if (i == 0) {
                listSort.get(i).click();

                break;
            }
        }


    }




}

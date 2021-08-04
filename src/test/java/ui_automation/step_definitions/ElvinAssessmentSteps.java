package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui_automation.pages.ElvinAssessmentPage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

import java.util.List;

public class ElvinAssessmentSteps {

    ElvinAssessmentPage elvinAssessmentPage = new ElvinAssessmentPage();

    String newBuyPrice;
    String priceBeforeCheckout;
    String priceAtCheckout;




    @Given("I visit Amazon homepage")
    public void i_visit_Amazon_homepage() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "amazon.url"));
        Driver.getDriver().manage().window().maximize();

    }

    @When("search for the book {string}")
    public void search_for_the_book(String name) throws InterruptedException {
        elvinAssessmentPage.amazonSearchField.sendKeys(name);
        Thread.sleep(3000);

    }

    @Then("press Search button and click on first item in the list results")
    public void press_Search_button_and_click_on_first_item_in_the_list_results() throws InterruptedException {
        elvinAssessmentPage.amazonSearchButton.click();
        elvinAssessmentPage.results.get(0).click();


    }

    @Then("verify the book price before add item to Cart")
    public void verify_the_book_price_before_add_item_to_Cart() {
        newBuyPrice = elvinAssessmentPage.amazonNewBuyPrice.getText();
        System.out.println("Item price before add to cart::: " + newBuyPrice);

    }

    @Then("click on Add to cart button")
    public void click_on_Add_to_cart_button() throws InterruptedException {
        elvinAssessmentPage.amazonAddToCartButton.click();

    }

    @Then("verify item price before click Proceed to checkout")
    public void verify_item_price_before_click_Proceed_to_checkout() {
        Assert.assertEquals("Verify item price before checkout", elvinAssessmentPage.amazonPriceBeforeCheckout.getText(), newBuyPrice);

    }

    @Then("click on Proceed to checkout button")
    public void click_on_Proceed_to_checkout_button() {
        elvinAssessmentPage.amazonProceedToCheckoutButton.click();
        elvinAssessmentPage.amazonUsername.sendKeys("alex27_76@hotmail.com");
        elvinAssessmentPage.amazonContinueButton.click();
        elvinAssessmentPage.amazonPassword.sendKeys("Salexpl240676!!");
        elvinAssessmentPage.amazonSignInButton.click();


    }

    @Then("verify item price from checkout page")
    public void verify_item_price_from_checkout_page() {
        priceAtCheckout = elvinAssessmentPage.amazonPriceAtCheckout.getText();
        Assert.assertEquals("Verify price at checkout and before checkout", elvinAssessmentPage.amazonPriceAtCheckout.getText(),priceAtCheckout);


    }



}

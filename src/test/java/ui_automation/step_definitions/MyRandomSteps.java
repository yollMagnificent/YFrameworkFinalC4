package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.pages.MyRandomPage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

import java.util.List;

public class MyRandomSteps {

    MyRandomPage myRandomPage = new MyRandomPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @Given("I navigate to the url")
    public void i_navigate_to_the_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "myurl1.url"));
        String webPageTitle = Driver.getDriver().getTitle();
        System.out.println("The title of webpage is:::::::" + webPageTitle);

    }

    @When("I checked all checkboxes")
    public void i_checked_all_checkboxes() {
        myRandomPage.checkBox_1.click();
        myRandomPage.checkBox_2.click();
        myRandomPage.checkBox_3.click();

    }

    @Then("I verify that all checkboxes are checked")
    public void i_verify_that_all_checkboxes_are_checked() {
        System.out.println("The checkbox1 selection state is:::::" + myRandomPage.checkBox_1.isSelected());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("The checkbox1 selection state is:::::" + myRandomPage.checkBox_1.isSelected());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("The checkbox1 selection state is:::::" + myRandomPage.checkBox_1.isSelected());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

    }

    @Then("I unchecked all checkboxes")
    public void i_unchecked_all_checkboxes() {
        myRandomPage.checkBox_1.click();
        myRandomPage.checkBox_2.click();
        myRandomPage.checkBox_3.click();

    }

    @Then("I verify checkboxes are unchecked")
    public void i_verify_checkboxes_are_unchecked() {
        System.out.println("The checkbox1 selection state is:::::" + myRandomPage.checkBox_1.isSelected());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("The checkbox1 selection state is:::::" + myRandomPage.checkBox_1.isSelected());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("The checkbox1 selection state is:::::" + myRandomPage.checkBox_1.isSelected());
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

    }


    @Then("I got count all checkboxes in the page")
    public void iGotCountAllCheckboxesInThePage() {
        List<WebElement> allChecks = Driver.getDriver().findElements(By.xpath("//*[@type='checkbox']"));
        int count = 0;
        for (int i=0; i<allChecks.size(); i++) {
            allChecks.get(i);
            count++;

        }
        System.out.println("Number of checkboxes in the page is::::::" + count);
    }




    @Given("I navigate to the correct url")
    public void i_navigate_to_the_correct_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "myurl2.url"));
        Driver.getDriver().manage().window().maximize();
        String webPageTitle = Driver.getDriver().getTitle();
        System.out.println("The title of webpage is:::::::" + webPageTitle);

    }

    @When("I fill out date adults and childrens and infants")
    public void i_fill_out_date_adults_and_childrens_and_infants() throws InterruptedException {
//        myRandomPage.calendar.click();

        wait.until(ExpectedConditions.elementToBeClickable(myRandomPage.adultsDropDown));
        Select adults = new Select(myRandomPage.adultsDropDown);
        adults.selectByValue("2");
        wait.until(ExpectedConditions.elementToBeClickable(myRandomPage.childrenDropDown));
        Select children = new Select(myRandomPage.childrenDropDown);
        children.selectByValue("2");
        wait.until(ExpectedConditions.elementToBeClickable(myRandomPage.infantsDropDown));
        Select infant = new Select(myRandomPage.infantsDropDown);
        infant.selectByValue("1");
        Thread.sleep(5000);



    }

    @When("I press on more options")
    public void i_press_on_more_options() {
        myRandomPage.moreOptionsbtn.click();

    }

    @Then("I choose preferred class")
    public void i_choose_preferred_class() {
        wait.until(ExpectedConditions.elementToBeClickable(myRandomPage.classDrop));
        Select classOfTravel = new Select(myRandomPage.classDrop);
        classOfTravel.selectByVisibleText("Business");

    }

    @Then("I press search flights button")
    public void i_press_search_flights_button() {
        wait.until(ExpectedConditions.elementToBeClickable(myRandomPage.searchFlightsBtn)).click();


    }

    @Then("I verify error message {string}")
    public void i_verify_error_message(String errorMessage) {
        Assert.assertEquals(errorMessage, myRandomPage.errorMsg.getText());

    }





    @Given("I navigate to the Ajax! webpage")
    public void i_navigate_to_the_Ajax_webpage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "myurl3.url"));
        Driver.getDriver().manage().window().maximize();
        String webPageTitle = Driver.getDriver().getTitle();
        System.out.println("The title of webpage is:::::::" + webPageTitle);

    }

    @When("I click on load link")
    public void i_click_on_load_link() {
        myRandomPage.ajaxLink.click();


    }

    @When("I verify result message {string}")
    public void i_verify_result_message(String resultMsg) {
        wait.until(ExpectedConditions.visibilityOf(myRandomPage.resultMsg));
        Assert.assertEquals(myRandomPage.resultMsg.getText(), resultMsg);

    }









}

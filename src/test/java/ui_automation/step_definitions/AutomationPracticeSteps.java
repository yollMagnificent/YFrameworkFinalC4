package ui_automation.step_definitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import io.cucumber.java.en_old.Ac;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.pages.AutomationPracticePage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;
import ui_automation.utilities.SelectHelper;
import ui_automation.utilities.WaitHelper;

import java.security.Key;


public class AutomationPracticeSteps {

    static final Logger log = LogManager.getLogger(SelectHelper.class); //<-- installation of Log4j
    AutomationPracticePage automationPracticePage = new AutomationPracticePage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    Actions action = new Actions(Driver.getDriver());



    @Given("I navigate to AP page")
    public void i_navigate_to_AP_page() {
        log.info("Navigating to the page");
        Driver.getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "automationPractice.url"));

    }

    @Then("I hover over womens tab")
    public void i_hover_over_womens_tab() {
        //option 1
//        Actions builder = new Actions(Driver.getDriver());
//        Action mouseHoverOver = builder.moveToElement(automationPracticePage.womensTab).build();
//        mouseHoverOver.perform();

        //option 2 (more user friendly!!)
//        Actions actions = new Actions(Driver.getDriver());
        log.info("Hover over tab");
        action.moveToElement(automationPracticePage.womensTab).perform();
    }

    @Then("I click on casual dresses link")
    public void i_click_on_casual_dresses_link() {
        wait.until(ExpectedConditions.elementToBeClickable(automationPracticePage.womensTab));
        automationPracticePage.casualDressesLink.click();

    }

    @Then("I am navigated to casual dresses page")
    public void i_am_navigated_to_casual_dresses_page() {
        wait.until(ExpectedConditions.visibilityOf(automationPracticePage.casualDresses));
        System.out.println(automationPracticePage.casualDresses.getText());

    }
    //*****************RIGHT CLICK**********************************************


    @Given("User navigated to contexMenu website")
    public void user_navigated_to_contexMenu_website() {
        Driver.getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "swisnl.url"));

    }

    @When("User clicks on the button")
    public void user_clicks_on_the_button() {
        wait.until(ExpectedConditions.elementToBeClickable(automationPracticePage.rightClick));
        action.contextClick(automationPracticePage.rightClick).perform();
        automationPracticePage.clickContentMenu.click();

    }

    @Then("User should be able to verify alert")
    public void user_should_be_able_to_verify_alert() throws InterruptedException {
        Thread.sleep(5000);
        Alert myAlert = Driver.getDriver().switchTo().alert();
        System.out.println(myAlert.getText());
        Thread.sleep(5000);
        myAlert.accept();
    }

    //****************BUILD*****************************
        @When("User performs series of actions on search box")
        public void user_performs_series_of_actions_on_search_box() {
        action.
                moveToElement(automationPracticePage.searchBox).
                click().
                keyDown(automationPracticePage.searchBox, Keys.SHIFT).
                sendKeys("jeans").
                keyUp(automationPracticePage.searchBox, Keys.SHIFT).
                doubleClick(automationPracticePage.searchBox).
                build().
                perform();
        automationPracticePage.searchBtn.click();
    }

        @Then("User should be able to verify {string} results")
        public void user_should_be_able_to_verify_search_results(String expectedMsg) {
            expectedMsg = automationPracticePage.expectedMsg;
            Assert.assertEquals(automationPracticePage.noResultText.getText(), expectedMsg);
        }

        //**************TOOLTIPS***********************

    @Given("User navigated to the tooltip URL")
    public void user_navigated_to_the_tooltip_URL() {
        Driver.getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "tooltip.url"));

    }

    @When("User hover over to the input text field")
    public void user_hover_over_to_the_input_text_field() throws InterruptedException {
        Thread.sleep(8000);
        action.moveToElement(automationPracticePage.ageTextField).perform();
    }

    @Then("User should be able to verify {string}")
    public void user_should_be_able_to_verify_tooltip(String toolTip) {
        Assert.assertEquals(automationPracticePage.ageTextField.getAttribute("title"), toolTip);
    }

    //********************UPLOAD DOWNLOAD FILE********************

    @Given("USer navigated to herokuapp webpage")
    public void user_navigated_to_herokuapp_webpage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("ui-config.properties", "herokuapp.url"));


    }

    @When("User uploads a file")
    public void user_uploads_a_file() throws InterruptedException {
        automationPracticePage.fileUploadLink.click();
//        automationPracticePage.chooseFileBtn.click();
        Thread.sleep(5000);
        String filePath = "/src/test/resources/testData/fileUpload/API_DATA.txt";
        automationPracticePage.chooseFileBtn.sendKeys(System.getProperty("user.dir") + filePath);
        Thread.sleep(5000);
        automationPracticePage.uploadBtn.click();



    }

    @Then("user should be able to verify uploaded file")
    public void user_should_be_able_to_verify_uploaded_file() throws InterruptedException {
        Thread.sleep(5000);
        String expectedText = "API_DATA.txt";
        String actualText = automationPracticePage.fileUploadResult.getText();
        Assert.assertEquals("Uploaded file verification failed!:::::", expectedText, actualText);

    }


    @Then("User should be able to download the file")
    public void userShouldBeAbleToDownloadTheFile() throws InterruptedException {
        automationPracticePage.fileDownloadLink.click();
        Thread.sleep(5000);
        log.info("Clicking on download button");
        automationPracticePage.downloadBtn.click();

    }
}




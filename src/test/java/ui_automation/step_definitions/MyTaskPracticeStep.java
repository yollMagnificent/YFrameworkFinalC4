package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_automation.pages.MyTasksPracticePage;
import ui_automation.utilities.Driver;
import ui_automation.utilities.SelectHelper;

public class MyTaskPracticeStep {
    MyTasksPracticePage myTasksPracticePage = new MyTasksPracticePage();
    static final Logger log = LogManager.getLogger(SelectHelper.class);
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
    Actions action = new Actions(Driver.getDriver());


    @When("user navigates to hovers tab")
    public void user_navigates_to_hovers_tab() {
        myTasksPracticePage.hoversTab.click();


    }

    @When("user hover over images")
    public void user_hover_over_images() {
        log.info("Hover over the image::::::");
        action.moveToElement(myTasksPracticePage.imageOne).perform();





    }

    @Then("user press on view profile button")
    public void user_press_on_view_profile_button() {
        log.info("Click on the link::::");
        myTasksPracticePage.imageLinkOne.click();


    }

    @Then("user verify the message {string}")
    public void user_verify_the_message(String infoMessage) {
        log.info("Final message verification:::::");
        Assert.assertEquals("Message verification failed!!", myTasksPracticePage.finalMessage.getText(), infoMessage);


    }

    @When("user navigates to context menu tab")
    public void userNavigatesToContextMenuTab() {
        myTasksPracticePage.contextMenuTab.click();
    }

    @And("user right clicks on the target area")
    public void userRightClicksOnTheTargetArea() {
        log.info("Performing right click");
        wait.until(ExpectedConditions.elementToBeClickable(myTasksPracticePage.hotSpot));
        action.contextClick(myTasksPracticePage.hotSpot).perform();

    }

    @Then("user access alert and verify {string} of alert")
    public void userAccessAlertAndVerifyTextOfAlert(String alertText) throws InterruptedException {
        Thread.sleep(5000);
        Alert rightClickAlert = Driver.getDriver().switchTo().alert();
        log.info("Verify alert text");
        Assert.assertEquals("Alert message verification failed!!", rightClickAlert.getText(), alertText);

    }
}

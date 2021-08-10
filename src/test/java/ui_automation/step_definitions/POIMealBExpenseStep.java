package ui_automation.step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import ui_automation.pages.POIMealBExpensePage;
import ui_automation.utilities.Driver;
import ui_automation.utilities.ExcelUtility;
import ui_automation.utilities.WaitHelper;

public class POIMealBExpenseStep {

    POIMealBExpensePage poiMealBExpensePage = new POIMealBExpensePage();
    private String excelPath = System.getProperty("user.dir") + "/src/test/resources/testData/Keywords.xlsx";

    @Given("I am on Expense tab")
    public void i_am_on_Expense_tab() {
        poiMealBExpensePage.expensesTab.click();

    }

    @When("I select Create Meal & Entertament expense")
    public void i_select_Create_Meal_Entertament_expense() {
        poiMealBExpensePage.addExpenseDropdown.click();
        poiMealBExpensePage.mealAndEntertaimentOption.click();
        WaitHelper.waitForClickablility(poiMealBExpensePage.calendar, 5);

    }

    @Then("I fill out all of the fields on the modal")
    public void i_fill_out_all_of_the_fields_on_the_modal() throws Exception {
        String name = "", businessPurpose="", company="", projectName="";
        double amount = 0.0;
        poiMealBExpensePage.calendar.click();
        WebElement date = Driver.getDriver().findElement(By.xpath("(//*[@aria-label='08/07/2021'])[3]"));
        date.click();
        ExcelUtility.setExcelFile(excelPath, "Sheet1");
        amount=ExcelUtility.getCellDataAsDouble(1, 3);
        name= ExcelUtility.getCellData(1, 0);
        businessPurpose= ExcelUtility.getCellData(1, 4);
        company= ExcelUtility.getCellData(1, 5);
        projectName= ExcelUtility.getCellData(1, 6);
        poiMealBExpensePage.completeExpenseModal(amount, name, businessPurpose, company, projectName);



   }

    @When("I click on Save Button")
    public void i_click_on_Save_Button() throws InterruptedException {
        poiMealBExpensePage.saveBtn.click();


    }

    @Then("Modal window is closed")
    public void modal_window_is_closed() {
        WaitHelper.waitForClickablility(poiMealBExpensePage.addExpenseDropdown, 5);
        Assert.assertTrue(poiMealBExpensePage.modalWindow.isDisplayed());

    }

    @Then("my newly added expense is displayed on table")
    public void my_newly_added_expense_is_displayed_on_table() {

    }


    @Then("I can write to excel file")
    public void iCanWriteToExcelFile() throws Exception {
        ExcelUtility.setExcelFile(excelPath, "Sheet1");
        ExcelUtility.setCellData(excelPath, "Pizza", 1, 0);




    }


}

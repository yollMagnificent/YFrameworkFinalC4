package ui_automation.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui_automation.pages.MealBDashboardPage;
import ui_automation.pages.MealBExpensePage;

import java.util.List;
import java.util.Map;

public class MealBExpenseStep {

    MealBExpensePage mealBExpensePage = new MealBExpensePage();



    @Then("I see below options when clicked on column dropdown")
    public void i_see_below_options_when_clicked_on_column_dropdown(DataTable dataTable) {
        List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);
        mealBExpensePage.columnDropdown.click();
        //Use for loop
        for (int i=0; i<maps.size(); i++) {
            Assert.assertEquals(maps.get(i).get("option"), mealBExpensePage.columnOptions.get(i).getText());
        }



    }






}

package ui_automation.step_definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui_automation.pages.MealBDashboardPage;
import ui_automation.pages.MealBExpensePage;
import ui_automation.utilities.ConfigurationReader;
import ui_automation.utilities.Driver;

import java.sql.*;
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
//************JDBC************************************

    @Then("User should be able to verify UI data with DB data")
    public void userShouldBeAbleToVerifyUIDataWithDBData() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbURL = ConfigurationReader.getProperty("ui-config.properties", "mb.database.url");
        String userName = ConfigurationReader.getProperty("ui-config.properties", "mb.database.username");
        String password = ConfigurationReader.getProperty("ui-config.properties", "mb.database.password");

        Connection connection;
        Statement statement;
        ResultSet resultSet;
        String dataFromUI, dataFromDB;
        String query = "SELECT Name from Expenses  as expenses\n" +
                        "join AbpUserAccounts as users\n" +
                        "on users.UserId  = expenses.CreatorUserId \n" +
                        "WHERE users.UserName = 'alexpl76' and expenses .DeletionTime is NULL \n" +
                        "ORDER BY expenses.ExpenseDateTime DESC ";
        connection = DriverManager.getConnection(dbURL, userName, password);
        statement = connection.createStatement();
        resultSet = statement.executeQuery(query);



        //verification
        int i=0;
        while (resultSet.next()) {
            List<WebElement> datasFromUIElement = Driver.getDriver().findElements(By.xpath("//table[@id='expenses-table']//tbody/tr/td[2]"));
            dataFromUI = datasFromUIElement.get(i).getText();
            dataFromDB = resultSet.getString("Name");
            Assert.assertEquals("Row number " + i + " DB value and UI value match verification failed!", dataFromDB, dataFromUI);
            i++;



        }


    }
}

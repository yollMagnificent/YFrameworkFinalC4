package ui_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class POIMealBExpensePage {

    public POIMealBExpensePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id='navbar-second-toggle']//*[contains(text(), ' Expenses')]")
    public WebElement expensesTab;

    @FindBy(xpath = "(//*[contains(text(), 'Add expense')])[2]")
    public WebElement addExpenseDropdown;


    @FindBy(xpath = "(//*[text()= 'Meal & Entertainment'])[4]")
    public WebElement mealAndEntertaimentOption;


    @FindBy(id = "ExpenseDateTime")
    public WebElement calendar;


    @FindBy(id = "Amount")
    public WebElement amountTextField;



    @FindBy(name = "Name")
    public WebElement expenseName;


    @FindBy(id = "BusinessPurpose")
    public WebElement businessPurposeTextField;


    @FindBy(id = "Company")
    public WebElement companyTextField;

    @FindBy(id = "ProjectName")
    public WebElement projectNameTextField;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement saveBtn;

    @FindBy(id = "ExpenseEditForm")
    public WebElement modalWindow;


    public void completeExpenseModal(double amount, String name, String businessPurpose, String company, String projectName) {
        calendar.click();
        WebElement date = Driver.getDriver().findElement(By.xpath("(//*[@aria-label='08/07/2021'])[3]"));
        date.click();
        amountTextField.sendKeys(String.valueOf(amount));
        expenseName.sendKeys(name);
        businessPurposeTextField.sendKeys(businessPurpose);
        companyTextField.sendKeys(company);
        projectNameTextField.sendKeys(projectName);
    }

}

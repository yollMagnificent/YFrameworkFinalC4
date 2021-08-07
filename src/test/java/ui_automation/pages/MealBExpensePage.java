package ui_automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

import java.util.List;

public class MealBExpensePage {

    public MealBExpensePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(css = ".buttons-colvis")
    public WebElement columnDropdown;

    @FindBy(css = ".buttons-columnVisibility")
    public List<WebElement> columnOptions;



}

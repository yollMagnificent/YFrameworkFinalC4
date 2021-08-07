package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

import java.util.List;

public class MealBDashboardPage {
    WebDriver driver;

    public MealBDashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "brighttheme-icon-closer")
    public WebElement bannerXbutton;

    @FindBy(id = "HeaderCurrentUserName")
    public WebElement currentUserFullName;






}

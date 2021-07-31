package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class MealBLandingPage {
    WebDriver driver;

    public MealBLandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "SIGN IN")
    public WebElement singInButton;



}

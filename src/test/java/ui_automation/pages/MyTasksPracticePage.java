package ui_automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class MyTasksPracticePage {

    WebDriver driver;

    public MyTasksPracticePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Hovers']")
    public WebElement hoversTab;

    @FindBy(xpath = "(//*[@src='/img/avatar-blank.jpg'])[1]")
    public WebElement imageOne;

    @FindBy(xpath = "//*[@href='/users/1']")
    public WebElement imageLinkOne;

    @FindBy(xpath = "//*[text()='Not Found']")
    public WebElement finalMessage;

    @FindBy(xpath = "//*[text()='Context Menu']")
    public WebElement contextMenuTab;

    @FindBy(id = "hot-spot")
    public WebElement hotSpot;

}

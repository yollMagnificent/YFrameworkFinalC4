package ui_automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

import java.util.List;

public class MyRandomPage {

    public MyRandomPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "checkBoxOption1")
    public WebElement checkBox_1;

    @FindBy(id = "checkBoxOption2")
    public WebElement checkBox_2;

    @FindBy(id = "checkBoxOption3")
    public WebElement checkBox_3;


    @FindBy(className = "flex flex-middle p-relative homeCalender")
    public WebElement calendar;

    @FindBy(xpath = "(//*[@class='bc-neutral-100 bg-transparent'])[1]")
    public WebElement adultsDropDown;

    @FindBy(xpath =  "(//*[@class='bc-neutral-100 bg-transparent'])[2]")
    public WebElement childrenDropDown;

    @FindBy(xpath =  "(//*[@class='bc-neutral-100 bg-transparent'])[3]")
    public WebElement infantsDropDown;

    @FindBy(xpath = "//*[@href='javascript:void(0);']")
    public WebElement moreOptionsbtn;

    @FindBy(xpath = "(//*[@class='bc-neutral-100 bg-transparent'])[4]")
    public WebElement classDrop;

    @FindBy(xpath = "//button[.='Search flights']")
    public WebElement searchFlightsBtn;

    @FindBy(xpath = "//*[contains(text(),'Select Departure and Arrival airports/cities.')]")
    public WebElement errorMsg;


   @FindBy(linkText = "Click to load get data via Ajax!")
   public WebElement ajaxLink;


    @FindBy(id = "results")
    public WebElement resultMsg;







}

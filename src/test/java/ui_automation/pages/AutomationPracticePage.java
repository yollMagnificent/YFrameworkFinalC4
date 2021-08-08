package ui_automation.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

public class AutomationPracticePage {

    WebDriver driver;

    public AutomationPracticePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Women']")
    public WebElement womensTab;

    @FindBy(xpath = "(//a[@title='Casual Dresses'])[1]")
    public WebElement casualDressesLink;

    @FindBy(xpath = "//*[@class='page-heading product-listing']")
    public WebElement casualDresses;

    //******************RIGHT CLICK************************************

    @FindBy(xpath = "//span[text()='right click me']")
    public WebElement rightClick;


    @FindBy(xpath = "//li[contains(@class, 'icon-cut')]")
    public WebElement clickContentMenu;

    //*************BUILD************************

    @FindBy(id = "searchbox")
    public WebElement searchBox;

    @FindBy(name = "submit_search")
    public WebElement searchBtn;

    @FindBy(xpath = "//*[@class='alert alert-warning']")
    public WebElement noResultText;

    public String expectedMsg = "No results were found for your search \"JEANS\"";

    //******************TOOLTIPS******************************

    @FindBy(id = "age")
    public WebElement ageTextField;

    public String toolTip = "We ask for your age only for statistical purposes.";

    //*************UPLOAD DOWNLOAD***************
    @FindBy(xpath = "//*[@href='/upload']")
    public WebElement fileUploadLink;


    @FindBy(id = "file-upload")
    public WebElement chooseFileBtn;

    @FindBy(id = "file-submit")
    public WebElement uploadBtn;

    @FindBy(id = "uploaded-files")
    public WebElement fileUploadResult;

    @FindBy(xpath = "//*[@href='/download']")
    public WebElement fileDownloadLink;

    @FindBy(xpath = "//*[text()='API_DATA.txt']")
    public WebElement downloadBtn;






}

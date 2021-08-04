package ui_automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui_automation.utilities.Driver;

import java.util.List;

public class ElvinAssessmentPage {

    WebDriver driver;

    public ElvinAssessmentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement amazonSearchField;

    @FindBy(id = "nav-search-submit-button")
    public WebElement amazonSearchButton;


    @FindBy(xpath = "//*[@class='s-main-slot s-result-list s-search-results sg-row']/div[2]")
    public WebElement amazonResult;

    @FindBy(id = "newBuyBoxPrice")
    public WebElement amazonNewBuyPrice;

    @FindBy(id = "add-to-cart-button")
    public WebElement amazonAddToCartButton;

    @FindBy(xpath = "//*[@class='a-size-base a-color-price a-text-bold']")
    public WebElement amazonPriceBeforeCheckout;

    @FindBy(id = "hlb-ptc-btn-native")
    public WebElement amazonProceedToCheckoutButton;

    @FindBy(xpath = "//*/table[1]/tbody[1]/tr[1]/td[2]")
    public WebElement amazonPriceAtCheckout;

    @FindBy(xpath = ".//span[@class='a-size-medium a-color-base a-text-normal']")
    public List<WebElement> results;

    @FindBy(id = "ap_email")
    public WebElement amazonUsername;

    @FindBy(id = "ap_password")
    public WebElement amazonPassword;

    @FindBy(id = "signInSubmit")
    public WebElement amazonSignInButton;

    @FindBy(id = "continue")
    public WebElement amazonContinueButton;















}

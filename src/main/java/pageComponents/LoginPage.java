package pageComponents;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.DriverUtils;
import utilities.OdsReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends DriverUtils {
    private WebDriver driver;
    private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "lQVLrA/nRk5VztLbA/Na4A==";
    private ConfigReader configReader = new ConfigReader();
    private OdsReader odsReader = new OdsReader();
    private static List<Object> loginDetails = new ArrayList<Object>();

    //*****************Locators***********************************//
    @FindBy(css = "input[name='userInput']")
    private WebElement txt_Email;

    @FindBy(xpath = "//span[contains(text(),'Send OTP')]")
    private WebElement btn_SendOTP;

    @FindBy(xpath = "//input[@name='otpInput1']")
    private WebElement txt_OTP;

    @FindBy(xpath = "//span[contains(text(),'Verify OTP')]")
    private WebElement btn_VerifyOTP;

    public LoginPage(WebDriver driver) throws IOException, InvalidFormatException {
        this.driver = driver;
        loginDetails = odsReader.getUserDetails(configReader.getUserDetails());
        PageFactory.initElements(driver, this);
    }

    public void enterUserEmailOrMobile(String fieldName, String value) {
        waitUntilVisible(txt_Email);
        sendKeys(txt_Email, value , true);
    }

    public HomePage clickSendOtpButton() {
        try {
            waitAndClick(btn_SendOTP);
        } catch (StaleElementReferenceException e) {
            btn_SendOTP.click();
        }
        return new HomePage(driver);
    }

    public void enterOTP(String fieldName,String value){
        sendKeys(txt_OTP,value,false);
    }
    public void clickOnVerifyOtpButton(){
        waitAndClick(btn_VerifyOTP);
    }
}
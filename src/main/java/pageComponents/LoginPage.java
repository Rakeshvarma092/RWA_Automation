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

    @FindBy(xpath = "//h1[text()='Log in to United Gates']")
    private WebElement title_Login;
    @FindBy(xpath = "//input[@name='userInput']")
    private WebElement txt_EmailID;
    @FindBy(xpath = "//span[contains(text(),'Send OTP')]")
    private WebElement btn_SendOTP;
    @FindBy(xpath = "//input[@name='otpInput1']")
    private WebElement txt_OTP;
    @FindBy(xpath = "//span[contains(text(),'Verify and Login')]")
    private WebElement btn_VerifyOTP;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void isLoginTitleDisplayed() {
        waitUntilVisible(title_Login);
    }

    public void enterEmailID(String email) {
        sendKeys(txt_EmailID, email, true);
    }

    public void clickSendOTP() {
        waitAndClick(btn_SendOTP);
    }

    public void enterOTP(String otp) {
        sendKeys(txt_OTP, otp, true);
    }

    public void clickVerifyAndLogin() {
        waitAndClick(btn_VerifyOTP);
    }
}
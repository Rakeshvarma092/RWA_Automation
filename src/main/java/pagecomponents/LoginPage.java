package pagecomponents;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends DriverUtils {
    // ==================== LOCATORS ====================

    @FindBy(xpath = "//p[text()='Log in to United Gates']")
    private WebElement loginTitle;

    @FindBy(xpath = "//input[@name='userInput']")
    private WebElement txt_EmailID;

    @FindBy(xpath = "//span[contains(text(),'Send OTP')]")
    private WebElement btn_SendOTP;

    @FindBy(xpath = "//input[@name='otpInput1']")
    private WebElement txt_OTP;

    @FindBy(xpath = "//span[contains(text(),'Verify and Login')]")
    private WebElement btn_VerifyOTP;

    // ==================== CONSTRUCTOR ====================

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ==================== PAGE ACTIONS ====================
    public boolean isLoginTitleDisplayed() {
        waitUntilVisible(loginTitle);
        return loginTitle.isDisplayed();
    }

    public void enterEmailID(String email) {
        sendKeys(txt_EmailID, email, true);
    }

    public void clickSendOTP() {
        waitAndClick(btn_SendOTP);
    }

    public void enterOTP(String otp) {
        waitUntilVisible(txt_OTP);
        sendKeys(txt_OTP, otp, true);
    }

    public void clickVerifyAndLogin() {
        waitAndClick(btn_VerifyOTP);
    }

    public void loginWithOTP(String email, String otp) {
        enterEmailID(email);
        clickSendOTP();
        enterOTP(otp);
        clickVerifyAndLogin();
    }
}

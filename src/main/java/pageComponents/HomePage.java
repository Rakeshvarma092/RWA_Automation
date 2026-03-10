package pageComponents;

import org.apache.logging.log4j.core.Core;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.DriverUtils;
import utilities.OdsReader;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class HomePage extends DriverUtils {
    private WebDriver driver;

    //*****************Locators***********************************//
    @FindBy(xpath = "//p[text()=' Welcome to United Gates']")
    private WebElement title_SystemAdmin;

    @FindBy(xpath = "//p[text()='Your community, now smarter and safer.']")
    private WebElement title_CommunityAdmin;

    @FindBy(xpath = "//p[text()='Your Community,now smarter and safer']")
    private WebElement title_PropertyAdmin;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifySystemHomePage() {
        waitUntilVisible(title_SystemAdmin);
    }

    public void verifyCommunityHomePage() {
        waitUntilVisible(title_CommunityAdmin);
    }

    public void verifyPropertyHomePage() {
        waitUntilVisible(title_PropertyAdmin);
    }

}
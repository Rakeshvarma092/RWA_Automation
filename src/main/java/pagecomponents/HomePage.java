package pagecomponents;

import org.apache.logging.log4j.core.Core;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class HomePage extends DriverUtils {
    private WebDriver driver;

    // ==================== LOCATORS ====================

    @FindBy(xpath = "//span[contains(text(),'(System Admin)')]")
    private WebElement systemAdminRole;

    @FindBy(xpath = "//span[contains(text(),'(Community Admin)')]")
    private WebElement communityAdminRole;

    @FindBy(xpath = "//span[contains(text(),'(Property Admin)')]")
    private WebElement propertyAdminRole;

    // ==================== CONSTRUCTOR ====================
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ==================== PAGE ACTIONS ====================

    public void verifyRoleDisplayed(String role) {
        switch (role.toUpperCase()) {
            case "SYSTEM ADMIN":
                waitUntilVisible(systemAdminRole);
                break;
            case "COMMUNITY ADMIN":
                waitUntilVisible(communityAdminRole);
                break;
            case "PROPERTY ADMIN":
                waitUntilVisible(propertyAdminRole);
                break;
            default:
                throw new IllegalArgumentException("Unknown role: '" + role + "'. Valid: 'System Admin', 'Community Admin', 'Property Admin'");
        }
    }

}

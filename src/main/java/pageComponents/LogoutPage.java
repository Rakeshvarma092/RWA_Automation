package pageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class LogoutPage extends DriverUtils {

    @FindBy(xpath = "(//button[@class='mat-mdc-menu-trigger menuProfile'])[1]")
    private WebElement btn_Profile;

    @FindBy(xpath = "//p[contains(text(),'System Admin Profile')]")
    private WebElement verify_SystemAdminProfile;

    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    private WebElement btn_Logout;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProfile() {
        waitAndClick(btn_Profile);
    }

    public boolean isSystemAdminProfileDisplayed() {
        waitUntilVisible(verify_SystemAdminProfile);
        return verify_SystemAdminProfile.isDisplayed();
    }

    public void clickLogout() {
        waitAndClick(btn_Logout);
    }
}
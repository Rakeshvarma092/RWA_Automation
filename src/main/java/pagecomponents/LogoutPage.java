package pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

public class LogoutPage extends DriverUtils {


    //====================== Locators ======================//

    @FindBy(xpath = "(//button[@class='mat-mdc-menu-trigger menuProfile'])[1]")
    private WebElement btn_Profile;

    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    private WebElement btn_Logout;


    //======================= Constructor =====================//
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //======================= Page Actions =====================//
    public void logout() {
        waitAndClick(btn_Profile);
        waitAndClick(btn_Logout);
    }
}

package pageComponents;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtils;

import java.io.IOException;

public class CompanyManagementPage extends DriverUtils {

    private WebDriver driver;

    @FindBy(xpath = "//span[normalize-space()='add_business']")
    private WebElement nav_CompanyManagement;
    @FindBy(xpath = "//a[text()='Company Management']")
    private WebElement title_OnboardCompany;
    @FindBy(xpath = "//span[text()=' Add Company ']")
    private WebElement btn_AddCompany;

    public CompanyManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void navigateToCompanyManagement(){
        waitAndClick(nav_CompanyManagement);
    }
    public void verifyPage(){
        waitUntilVisible(title_OnboardCompany);
    }
    public void clickAddCompany(){
        waitAndClick(btn_AddCompany);
    }
}

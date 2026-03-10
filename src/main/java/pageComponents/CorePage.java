package pageComponents;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utilities.*;

import java.io.IOException;

public class CorePage extends DriverUtils {
    public HomePage homePage = new HomePage(driver);
    public LoginPage loginPage = new LoginPage(driver);
    public CompanyManagementPage companyManagementPage = new CompanyManagementPage(driver);
    public OnboardCompanyPage onboardCompanyPage = new OnboardCompanyPage(driver);
    public OdsReader odsReader = new OdsReader();
    public OTPSteps otpSteps = new OTPSteps();
    public ConfigReader configReader = new ConfigReader();
    public MailReader mailReader = new MailReader();
    public String testDataPath = System.getProperty("user.dir") + "\\testData\\";
    protected CorePage() throws IOException, InvalidFormatException {
    }
}
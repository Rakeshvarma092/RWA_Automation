package pageComponents;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utilities.*;

import java.io.IOException;

public class CorePage extends DriverUtils {
    public HomePage homePage = new HomePage(driver);
    public LoginPage loginPage = new LoginPage(driver);
    public CompanyManagementPage companyManagementPage = new CompanyManagementPage(driver);
    public LogoutPage logoutPage = new LogoutPage(driver);
    public BankConfigurationPage bankConfigurationPage = new BankConfigurationPage(driver);
    public ProjectOnboardingPage projectOnboardingPage = new ProjectOnboardingPage(driver);
    public StructurePage structurePage = new StructurePage(driver);
    public OwnershipClassificationPage ownershipClassificationPage = new OwnershipClassificationPage(driver);
    public MasterDataPage masterDataPage = new MasterDataPage(driver);
    public ChargesPage chargesPage = new ChargesPage(driver);
    public StagePage stagePage = new StagePage(driver);
    public OdsReader odsReader = new OdsReader();
    public OTPSteps otpSteps = new OTPSteps();
    public ConfigReader configReader = new ConfigReader();
    public MailReader mailReader = new MailReader();
    public String testDataPath = System.getProperty("user.dir") + "\\testData\\";
    protected CorePage() throws IOException, InvalidFormatException {
    }
}
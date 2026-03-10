package stepDefinitions;

//import DataBase.MongoDB;
import DriverFactory.WebDriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utilities.ConfigReader;
import utilities.ExtentReader;
import utilities.MailReader;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ApplicationHooks extends WebDriverFactory {
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();
    public static MailReader mailReader = new MailReader();
    public static ExtentSparkReporter spark;
    private WebDriverFactory driverFactory;
    private ConfigReader configReader;
    private ExtentReader extentReader;
    public static Scenario scenario;
    public static String scenarioName;
    public static Properties properties;

//    public static MongoDB db = new MongoDB();

    @Before(order = 0)
    public void initialization(Scenario scenario) throws IOException {
        this.scenario = scenario;
        spark = new ExtentSparkReporter("./ExtentReports-Verbose/AutomationReport-" + dateFormat() + "/Automation-Report.html");
        configReader = new ConfigReader();
        extentReader = new ExtentReader();
        properties = configReader.init_Prop();
        driverFactory = new WebDriverFactory();
        extent.attachReporter(spark);
        test = extent.createTest(scenarioName());
        extentReader.updateExtentPropertiesValue("basefolder.name", "Reports/reports-" + dateFormat() + "/reports");
        deleteFiles("Reports");
        deleteFiles("Screenshots");
        scenarioName = scenario.getSourceTagNames().toString().trim();
    }

    @Before("@Browser")
    public void launchBrowser() throws IOException {
        if (driver != null) {
            driver.quit();
        }
        driver = driverFactory.init_driver(configReader.getBrowserConfiguration());
    }

    @After(order = 0)
    public void setExtent() {
        extent.flush();
    }

    @After(order = 2)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed() && driver != null) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

    @After(order = 1)
    public void saveScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed() && driver != null) {
            DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
            Date date = new Date();
            String date1 = dateFormat.format(date);
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "jpg", new File(".\\Screenshots\\" + screenshotName + "-" + date1 + ".jpg"));
        }
    }

    public void deleteFiles(String Directory) {
        long numDays = 1;
        String dir = ".\\" + Directory;
        File directory = new File(dir);
        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {
                long diff = new Date().getTime() - file.lastModified();
                long cutoff = (numDays * (24 * 60 * 60 * 1000));
                if (diff > cutoff) {
                    try {
                        FileUtils.forceDelete(file);
                    } catch (Exception e) {

                    }
                }
            }
        }
    }

    public String scenarioName() {
        return scenario.getName();
    }

    public String dateFormat() {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

}

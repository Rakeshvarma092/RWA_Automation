package utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class OTPSteps {

    private AppiumDriver androidDriver;

    public String fetchSMS() throws MalformedURLException {
        String result;
        setupDriver();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("max", 3);
        result = androidDriver.executeScript("mobile: listSms", map).toString();
        tearDown();
        return result;
    }

    public void setupDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appium:deviceName", "8653505c");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:udid", "8653505c");
        capabilities.setCapability("autoGrantPermissions", true);
        androidDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), capabilities);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void tearDown() {
        if (androidDriver != null) {
            androidDriver.quit();
        }
    }
}

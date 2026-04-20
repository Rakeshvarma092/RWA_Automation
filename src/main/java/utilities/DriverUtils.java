package utilities;

import driverfactory.WebDriverFactory;
import com.github.javafaker.Faker;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.crypto.Cipher;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.Collections;


public class DriverUtils extends WebDriverFactory {

    private static FileInputStream fis;
    private static final Set<String> GENERATED_COMPANY_NAMES = new HashSet<>();
    private static final Set<String> GENERATED_RANDOM_NAMES = new HashSet<>();
    private static final Set<String> GENERATED_PHONE_NUMBERS = new HashSet<>();
    private static final Set<String> GENERATED_PAN_NUMBERS = new HashSet<>();
    private static final Set<String> GENERATED_AADHAAR_NUMBERS = new HashSet<>();
    private static final Set<String> GENERATED_GSTIN_NUMBERS = new HashSet<>();
    private static final Set<String> GENERATED_CIN_NUMBERS = new HashSet<>();
    private static final Set<String> GENERATED_ISO_NUMBERS = new HashSet<>();

    private static final String USER_DIR_TESTDATA =
            System.getProperty("user.dir") + File.separator + "testData";

    // ---------------------- WAIT HELPERS ----------------------

    public static void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    public static void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
    }

    public static void waitUntilVisible(By locator) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public static void waitUntilAllElementsVisible(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitUntilNotVisible(WebElement element) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.invisibilityOf(element)));
    }

    // ---------------------- BASIC ACTIONS ----------------------

    public static void sendKeys(WebElement element, CharSequence value, boolean clickElement) {
        waitUntilVisible(element);
        if (clickElement) {
            element.click();
        }
        element.clear();
        if (value != null) {
            element.sendKeys(value);
        }
    }

    public void selectValueInSelector(WebElement element, String value) {
        waitUntilVisible(element);
        if (value != null) {
            new Select(element).selectByVisibleText(value);
        }
    }

    public static void waitAndClick(WebElement element) {
        try {
            waitUntilClickable(element);
            jClick(element);
        } catch (ElementClickInterceptedException | StaleElementReferenceException e) {
            element.click();
        }
    }

    public static void waitAndClick(By locator) {
        try {
            WebElement ele = driver.findElement(locator);
            waitUntilClickable(ele);
            ele.click();
        } catch (StaleElementReferenceException | ElementNotInteractableException e) {
            WebElement ele = driver.findElement(locator);
            ele.click();
        }
    }

    public static void customDropDownSelection(WebElement dropdown, WebElement option) {
        waitAndClick(dropdown);
        waitAndClick(option);
    }

    public static void customDropDownSelection(WebElement dropdown, By option) {
        waitAndClick(dropdown);
        waitAndClick(option);
    }

    public void scrollIntoView(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }

    public void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void jClick(WebElement element) {
        waitUntilVisible(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void hardWait(int timeMs) {
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    // ---------------------- ALERT & WINDOWS ----------------------

    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public Set<String> getWindowHandles() {
        hardWait(5000);
        return driver.getWindowHandles();
    }

    // ---------------------- TEXT / ELEMENT HELPERS ----------------------

    public String getText(WebElement element) {
        waitUntilVisible(element);
        return element.getText();
    }

    public String getText(By locator) {
        waitUntilVisible(locator);
        return driver.findElement(locator).getText();
    }

    public List<WebElement> findElements(By locator) {
        waitUntilVisible(locator);
        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public static void switchToFrame(WebElement frameElement) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }

    public void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public String getAttributeValues(WebElement element, String attribute) {
        waitUntilVisible(element);
        return element.getAttribute(attribute);
    }

    // ---------------------- RANDOM UTILITIES ----------------------

    /**
     * Generates a short random string based on UUID (first segment).
     */
    public static String generateRandomString() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().split("-")[0];
    }

    public int generateRandomNumber(int max, int min) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    // ---------------------- DATE UTILITIES ----------------------

    public String getCurrentDate(String pattern) {
        List<String> dateList = new ArrayList<>();
        String actualDate = null;

        if (!pattern.contains("T")) {
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            Date date = new Date();
            actualDate = dateFormat.format(date);
        } else {
            String[] timeAndDate = pattern.split("T");
            for (String s : timeAndDate) {
                DateFormat dateFormat = new SimpleDateFormat(s.replace("'", ""));
                Date date = new Date();
                actualDate = dateFormat.format(date);
                dateList.add(actualDate);
            }
            actualDate = dateList.get(0) + "T" + dateList.get(1);
        }

        return actualDate;
    }

    public Date convertDateFormat(String currentDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(currentDate);
    }

    /**
     * Returns current date +/- days in given pattern.
     * Note: When using a non-ISO pattern, LocalDate.parse() may fail – keep pattern compatible with yyyy-MM-dd.
     */
    public static String getCurrentDatePlusOrMinus(String pattern, int count) {
        List<String> dateList = new ArrayList<>();
        String actualDate = null;

        if (!pattern.contains("T")) {
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            Date date = new Date();
            actualDate = dateFormat.format(date);

            // This assumes 'actualDate' is ISO compatible for LocalDate.parse()
            LocalDate localDate = LocalDate.parse(actualDate).plusDays(count);
            actualDate = localDate.toString();
        } else {
            String[] timeAndDate = pattern.split("T");
            boolean dateAdd = false;
            for (String s : timeAndDate) {
                DateFormat simpleDateFormat = new SimpleDateFormat(s.replace("'", ""));
                Date currentDate = new Date();
                actualDate = simpleDateFormat.format(currentDate);

                if (!dateAdd) {
                    LocalDate localDate = LocalDate.parse(actualDate).plusDays(count);
                    actualDate = localDate.toString();
                    dateAdd = true;
                }
                dateList.add(actualDate);
            }
            actualDate = dateList.get(0) + "T" + dateList.get(1);
        }
        return actualDate;
    }

    // ---------------------- FILE DOWNLOAD UTILITIES ----------------------

    public boolean isFileDownloaded(String fileName, String downloadDir) {
        String filesDirectory = System.getProperty("user.home") + File.separator + downloadDir;

        return wait.until((ExpectedCondition<Boolean>) d -> {
            File folder = new File(filesDirectory);
            File[] allFiles = folder.listFiles();
            if (allFiles == null) {
                return false;
            }

            for (File file : allFiles) {
                String eachFile = file.getName();
                if (eachFile.contains(fileName)) {
                    return true;
                }
            }
            return false;
        });
    }

    public boolean deleteDownloadedFile(String fileName, String downloadDir) {
        String filesDirectory = System.getProperty("user.home") + File.separator + downloadDir;

        return wait.until((ExpectedCondition<Boolean>) d -> {
            File folder = new File(filesDirectory);
            File[] allFiles = folder.listFiles();
            if (allFiles == null) {
                return false;
            }

            for (File file : allFiles) {
                String eachFile = file.getName();
                if (eachFile.contains(fileName)) {
                    //noinspection ResultOfMethodCallIgnored
                    file.delete();
                    return true;
                }
            }
            return false;
        });
    }

    public static void verifyFile(String fileName) {
        try {
            fis = new FileInputStream(USER_DIR_TESTDATA + File.separator + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // ---------------------- ENCRYPTION ----------------------

    public String rsaEncryption(String pubKey, String text) throws Exception {
        PublicKey publicKey = loadPublicKey(pubKey);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.encodeBase64(bytes), StandardCharsets.UTF_8);
    }

    /**
     * Loads RSA PublicKey from a Base64-encoded string (recommended format).
     */
    private PublicKey loadPublicKey(String key) throws Exception {
        // If key is Base64-encoded, decode it first
        byte[] publicKeyBytes = Base64.decodeBase64(key);

        KeyFactory publicKeyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
        return publicKeyFactory.generatePublic(publicKeySpec);
    }

    // ---------------------- WAITS / ACTIONS ----------------------

    public static void fluentWait(WebElement element) {
        fluentWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void keyBoardActions(String action) {
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys(action)
                .keyUp(Keys.CONTROL)
                .perform();
    }

    public static void tabButton() {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.TAB).perform();
        act.sendKeys(Keys.RETURN).perform();
    }

    public static void escButton() {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ESCAPE).perform();
        act.sendKeys(Keys.RETURN).perform();
    }

    public static void moveToElement(WebElement ele) {
        new Actions(driver).moveToElement(ele).perform();
    }

    public static void pressEnter() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(300);
    }

    // ---------------------- COLLECTION UTILITIES ----------------------

    public static Set<String> getText(List<WebElement> elements) {
        Set<String> data = new HashSet<>();
        for (WebElement element : elements) {
            data.add(element.getText());
        }
        return data;
    }

    // ---------------------- RANDOM NAME / PHONE GENERATION ----------------------

    public static String generateName() {
        String name;
        while (true) {
            int length = (int) (Math.random() * 10) + 3; // 3–12

            StringBuilder sb = new StringBuilder();
            sb.append((char) ('A' + Math.random() * 26)); // First uppercase

            for (int i = 1; i < length; i++) {
                sb.append((char) ('a' + Math.random() * 26)); // Lowercase
            }

            name = sb.toString();

            // Ensure uniqueness
            if (GENERATED_RANDOM_NAMES.add(name)) {
                break;
            }
        }
        return name;
    }

    public static String generatePhoneNumber() {
        String phoneNumber;
        while (true) {
            int firstDigit = (int) (Math.random() * 4) + 6; // 6–9
            long remainingDigits = (long) (Math.random() * 1_000_000_000L); // 9 digits

            phoneNumber = firstDigit + String.format("%09d", remainingDigits);

            if (GENERATED_PHONE_NUMBERS.add(phoneNumber)) {
                break;
            }
        }
        return phoneNumber;
    }

    public static String generatePAN() {
        String pan;
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) sb.append((char) ('A' + Math.random() * 26));
            sb.append('C'); // Fourth character 'C' for Company
            sb.append((char) ('A' + Math.random() * 26));
            for (int i = 0; i < 4; i++) sb.append((int) (Math.random() * 10));
            sb.append((char) ('A' + Math.random() * 26));
            pan = sb.toString();
            if (GENERATED_PAN_NUMBERS.add(pan)) break;
        }
        return pan;
    }

    public static String generateAadhar() {
        String aadhar;
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 12; i++) {
                sb.append((int) (Math.random() * 10));
            }
            aadhar = sb.toString();
            if (GENERATED_AADHAAR_NUMBERS.add(aadhar)) break;
        }
        return aadhar;
    }

    public static String generateGSTIN() {
        String gstin;
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%02d", (int) (Math.random() * 37) + 1));
            sb.append(generatePAN());
            sb.append((int) (Math.random() * 9) + 1);
            sb.append('Z');
            sb.append((char) ('0' + Math.random() * 10));
            gstin = sb.toString();
            if (GENERATED_GSTIN_NUMBERS.add(gstin)) break;
        }
        return gstin;
    }

    public static String generateCINumber() {
        String cin;
        String[] states = {"MH", "DL", "KA", "TN", "TS", "UP", "WB"};
        String[] entity = {"PTC", "PLC", "OPC", "LLP"};
        while (true) {
            StringBuilder sb = new StringBuilder();
            sb.append(Math.random() > 0.5 ? 'L' : 'U'); // L for Listed, U for Unlisted
            sb.append(String.format("%05d", (int)(Math.random() * 100000))); // Industry code
            sb.append(states[(int)(Math.random() * states.length)]); // State code
            sb.append((int)(Math.random() * 24) + 2000); // Year 2000-2023
            sb.append(entity[(int)(Math.random() * entity.length)]); // Entity type
            sb.append(String.format("%06d", (int)(Math.random() * 1000000))); // Registration Number
            
            cin = sb.toString();
            if (GENERATED_CIN_NUMBERS.add(cin)) break;
        }
        return cin;
    }

    public static String generateISONumber() {
        String iso;
        String[] isoTypes = {"9001", "27001", "14001", "45001", "22000"};
        while (true) {
            String base = isoTypes[(int)(Math.random() * isoTypes.length)];
            int year = (int)(Math.random() * 24) + 2000;
            iso = "ISO " + base + ":" + year;
            if (GENERATED_ISO_NUMBERS.add(iso)) break;
        }
        return iso;
    }
}

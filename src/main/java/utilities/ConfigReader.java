package utilities;


import java.io.*;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private String path = "./src/test/resources/config.properties";

    public Properties init_Prop() {
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream(path);
            properties.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public String getBrowserConfiguration() {
        return properties.getProperty("browser");
    }

    public String getAccountSID() {
        return properties.getProperty("AccountSID");
    }

    public String getAuthToken() {
        return properties.getProperty("AuthToken");
    }

    public String getNumber() {
        return properties.getProperty("PhoneNumber");
    }

    public String getUrlDetails() {
        return properties.getProperty(properties.getProperty("environment") + "_URL");
    }

    public String getUserDetails() {
        return properties.getProperty(properties.getProperty("environment") + "_userDetails");
    }

    public String getConnectionString() {
        return properties.getProperty("connectionString");
    }

    public String getDatabaseName() {
        return properties.getProperty("databaseName");
    }

    public String getCollectionName() {
        return properties.getProperty("collectionName");
    }

    public String getUserId() {
        return properties.getProperty("userId");
    }

    public String getCollectionField() {
        return properties.getProperty("collectionField");
    }
    public String getEmailUserId() {
        return properties.getProperty("userId");
    }

    public String getEMailUserPassword() {
        return properties.getProperty("emailPassword");
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}

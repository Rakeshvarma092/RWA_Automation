package utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TextFileReader extends DriverUtils{
    private static Properties properties;
    private static FileInputStream fis;
    private static String userDir = System.getProperty("user.dir") + "\\testData";

    public static Properties init_Prop(String fileName) {
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream(userDir + "\\" + fileName);
            properties.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public void updateTextFileValue(String fileName, String key, String value) throws IOException {
        try {
            init_Prop(fileName);
            FileOutputStream out = new FileOutputStream(userDir + "\\" + fileName);
            properties.setProperty(key, value);
            properties.store(out, null);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {

        }
    }

    public List<String> readAllDataFromTextFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        verifyFile(fileName);
        DataInputStream in = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        while ((strLine = br.readLine()) != null) {
            lines.add(strLine);
        }
        in.close();
        return lines;
    }

}

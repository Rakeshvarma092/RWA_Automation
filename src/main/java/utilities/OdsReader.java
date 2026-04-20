package utilities;


import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class OdsReader {
    private String userDir = System.getProperty("user.dir") + "\\testData";
    private File odsFile = new File(System.getProperty("user.dir") + "\\testData\\issuanceTestData.ods");
    private File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
    private File file;
    private SpreadSheet spreadSheet;
    private String loginSheetName = "IssuanceLoginDetails";
    private String currentUsersHomeDir = System.getProperty("user.home");
    private HashMap<Object, Object> testData = new HashMap<>();

    public Sheet odsInitialization(File file, String sheetName) throws IOException, InvalidFormatException {
        spreadSheet = SpreadSheet.createFromFile(file);
        return spreadSheet.getSheet(sheetName);
    }

    public List<Object> getUserDetails(String userDetails) throws IOException, InvalidFormatException {
        List<Object> li = new ArrayList<>();
        Object userName = null;
        Object password = null;
        try {
            Sheet sheet = odsInitialization(odsFile, loginSheetName);
            int row = sheet.getRowCount();
            int j = 0;
            for (int i = 0; i < row; i++) {
                Object details = sheet.getValueAt(j, i);
                if (details.equals(userDetails)) {
                    userName = sheet.getCellAt(j + 1, i).getValue();
                    password = sheet.getCellAt(j + 2, i).getValue();
                    li.add(userName);
                    li.add(password);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to load the ods corresponding sheet: " + loginSheetName + e.getMessage());
        }
        return li;
    }

    public HashMap<Object, Object> getSheetData(String sheetName) {
        try {
            Sheet sheet = odsInitialization(odsFile, sheetName);
            int columns = sheet.getColumnCount();
            int j = 0;
            for (int i = 0; i <= columns; i++) {
                testData.put(sheet.getValueAt(i, j), sheet.getValueAt(i, 1));
            }
        } catch (Exception e) {
            System.out.println("Failed to load the ods corresponding sheet: " + loginSheetName + e.getMessage());
        }
        return testData;
    }

    public HashMap<Object, List<Object>> getMultipleRowData(String sheetName) {
        HashMap<Object, List<Object>> rowsData = new HashMap<>();
        try {
            Sheet sheet = odsInitialization(odsFile, sheetName);
            int columns = sheet.getColumnCount();
            int rows = sheet.getRowCount();
            int j = 0;
            for (int i = 0; i <= columns; i++) {
                List<Object> data = new ArrayList<>();
                for (int k = 1; k < rows; k++) {
                    data.add(sheet.getValueAt(i, k));
                    rowsData.put(sheet.getValueAt(i, j), data);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to load the ods corresponding sheet: " + loginSheetName + e.getMessage());
        }
        return rowsData;
    }

    public HashMap<Object, List<Object>> getMultipleRowDataStartsWithColumnName(String sheetName, String columnName) {
        //j=column,i=row
        HashMap<Object, List<Object>> rowsData = new HashMap<>();
        try {
            file = changeFileFormat(".csv", ".ods");
            Sheet sheet = odsInitialization(file, sheetName);
            int rows = sheet.getRowCount();
            int j = 0, l = 0, i = 0, expectedColumns = 15;
            for (i = 0; i < rows; i++) {
                Object details = sheet.getValueAt(j, i);
                if (details.equals(columnName)) {
                    j = i;
                    for (int k = 0; k <= expectedColumns; k++) {
                        List<Object> data = new ArrayList<>();
                        for (l = i + 1; l < rows; l++) {
                            if (sheet.getValueAt(k, l).equals("")) {
                                data.add("Empty Record");
                            } else {
                                data.add(sheet.getValueAt(k, l));
                            }
                            rowsData.put(sheet.getValueAt(k, j), data);
                        }
                    }
                }
            }
            writeDataToOdsFile(sheetName, "Automation Status");
        } catch (Exception e) {
            System.out.println("Failed to load the ods corresponding sheet: " + loginSheetName + e.getMessage());
        }
        return rowsData;
    }

    public void writeDataToOdsFile(String sheetName, String data) {
        String name = null;
        try {
            file = getLatestDownloadedFile();
            name = file.getName();
            Workbook workbook = new Workbook(downloadDir + "\\" + name);
            Worksheet worksheet = workbook.getWorksheets().get(sheetName);
            worksheet.getCells().get("P5").putValue(data);
            workbook.save(downloadDir + "\\" + name);
        } catch (Exception e) {
            System.out.println("Failed to write data to file" + e.getMessage());
        }
    }

    public void writeDataToOdsFile(String sheetName, String column, int rowIndex, String data) {
        String name = null;
        try {
            file = getLatestDownloadedFile();
            name = file.getName();
            Workbook workbook = new Workbook(downloadDir + "\\" + name);
            Worksheet worksheet = workbook.getWorksheets().get(sheetName);
            worksheet.getCells().get(column + rowIndex).putValue(data);
            workbook.save(downloadDir + "\\" + name);
        } catch (Exception e) {
            System.out.println("Failed to write data to file" + e.getMessage());
        }
    }

    public void writeDataToTestData(String fileName, String sheetName, String column, int rowIndex, String data) {
        String name = null;
        try {
            Workbook workbook = new Workbook(userDir + "\\" + fileName);
            Worksheet worksheet = workbook.getWorksheets().get(sheetName);
            worksheet.getCells().get(column + rowIndex).putValue(data);
            workbook.save(userDir + "\\" + fileName);
        } catch (Exception e) {
            System.out.println("Failed to write data to file" + e.getMessage());
        }
    }

    public void saveOdsFile(String fileName, String sheetName) {
        try {
            Workbook workbook = new Workbook(userDir + "\\" + fileName);
            workbook.save(userDir + "\\" + fileName);
        } catch (Exception e) {
            System.out.println("Failed to write data to file" + e.getMessage());
        }
    }

    public void deleteSheetFromOdsFile(String fileName, String sheetName) {
        try {
            Workbook workbook = new Workbook(userDir + "\\" + fileName);
            for (int i = 1; i <= 20; i++) {
                Worksheet worksheet = workbook.getWorksheets().get(sheetName);
                // worksheet.re;
            }
            workbook.save(userDir + "\\" + fileName);
        } catch (Exception e) {
            System.out.println("Failed to delete sheet" + e.getMessage());
        }
    }

    public File getLatestDownloadedFile() throws IOException {
        File path = null;
        Path dir = Paths.get(currentUsersHomeDir + File.separator + "Downloads");
        Optional<Path> lastFilePath = Files.list(dir)
                .filter(f -> !Files.isDirectory(f))
                .max(Comparator.comparingLong(f -> f.toFile().lastModified()));
        if (lastFilePath.isPresent()) {
            path = lastFilePath.get().toFile();
        }
        return path;
    }

    public File changeFileFormat(String currentFormat, String requiredFormat) throws Exception {
        String name = null;
        try {
            file = getLatestDownloadedFile();
            name = file.getName();
            Workbook workbook = new Workbook(downloadDir + "\\" + name);
            workbook.save(downloadDir + "\\" + name.replace(currentFormat, "") + requiredFormat);
        } catch (Exception e) {
            System.out.println("Failed to retrieve latest file details" + e.getMessage());

        }
        return new File(downloadDir + "\\" + name.replace(currentFormat, "") + requiredFormat);
    }


}




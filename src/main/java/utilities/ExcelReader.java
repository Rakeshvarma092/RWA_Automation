package utilities;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    private WebDriver driver;
    private File excelFile = new File(System.getProperty("user.dir") + "\\testData\\login.xlsx");
    private File userDir = new File(System.getProperty("user.dir") + "\\testData");
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private Row row;
    private String loginSheetName = "loginDetails";

    public XSSFSheet excelInitialization(String sheetName) throws IOException, InvalidFormatException {
        workbook = new XSSFWorkbook(excelFile);
        return sheet = workbook.getSheet(sheetName);
    }

    public XSSFSheet excelInitialization(String workbookName, String sheetName) throws IOException, InvalidFormatException {
        FileInputStream fis = new FileInputStream(userDir + "\\" + workbookName);
        workbook = new XSSFWorkbook(fis);
        return sheet = workbook.getSheet(sheetName);
    }

    public List<String> getUserDetails(String userDetails) throws IOException, InvalidFormatException {
        List<String> li = new ArrayList<>();
        sheet = excelInitialization(loginSheetName);
        int row = sheet.getRow(0).getPhysicalNumberOfCells();
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        int length = sheet.getLastRowNum();
        String userName = null;
        String password = null;
        int j = 0;
        for (int i = 0; i <= length; i++) {
            String details = sheet.getRow(j).getCell(0).toString();
            if (details.equals(userDetails)) {
                userName = sheet.getRow(j).getCell(1).toString();
                password = sheet.getRow(j).getCell(2).toString();
                li.add(userName);
                li.add(password);
                break;
            } else {
                j = j + 1;
            }
        }
        closeExcel();
        return li;
    }

    public void closeExcel() throws IOException {
        workbook.close();
    }

    public static int findColumnIndex(Sheet sheet, String columnName, int rowIndex) {
        Row headerRow = sheet.getRow(rowIndex);
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equals(columnName)) {
                return cell.getColumnIndex();
            }
        }
        return -1;
    }

    public void writeDataToExcel(String workbookName, String sheetName, int rowIndex, int cellIndex, String data) throws IOException, InvalidFormatException {
        sheet = excelInitialization(workbookName, sheetName);
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }
        Cell cell = row.createCell(cellIndex);
        cell.setCellValue(data);
        FileOutputStream fos = new FileOutputStream(userDir + "\\" + workbookName);
        workbook.write(fos);
        fos.flush();
        fos.close();
    }

    public void writeDataToExcelFileWithColName(String workbookName, String sheetName, String colName, int colIndex, int rowIndex, String data) {
        try {
            FileInputStream fis = new FileInputStream(userDir + "\\" + workbookName);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            int columnIndex = findColumnIndex(sheet, colName, colIndex);
            int cellCount = getEmptyCellInRow(sheet, 3, columnIndex);
            row = sheet.getRow(cellCount);
            if (row == null) {
                row = sheet.createRow(cellCount);
            }
            Cell cell = row.getCell(columnIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            cell.setCellValue(data);
            FileOutputStream fos = new FileOutputStream(userDir + "\\" + workbookName);
            workbook.write(fos);
            fos.flush();
            fos.close();
            closeExcel();
        } catch (Exception e) {
            System.out.println("Failed to write data to file" + e.getMessage());
        }
    }

    public static int getEmptyCellInRow(Sheet sheet, int rowIndex, int colIndex) {
        int lastRow = sheet.getLastRowNum();
        for (int i = rowIndex; i <= lastRow; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                return i;
            }
            Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellType() == CellType.BLANK) {
                return i;
            }
        }
        return lastRow + 1;
    }

}




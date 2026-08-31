package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int columns = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][columns];

        for (int i = 1; i < rows; i++) {

            Row row = sheet.getRow(i);

            for (int j = 0; j < columns; j++) {

                data[i - 1][j] = row.getCell(j).toString();
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}
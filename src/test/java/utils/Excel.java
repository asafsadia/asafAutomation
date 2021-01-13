package utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* Read data from Excel file */
public class Excel {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow row;

	// Read date from excel file and return it as a 2D array Object
	public static Object[][] getTableArray(String filePath, String sheetName) {
		Object[][] tabArray = null;
		int temp = 0;
		try {
			// Initializing
			FileInputStream ExcelFile = new FileInputStream(filePath);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
			// get number of rows
			int rows = ExcelWSheet.getPhysicalNumberOfRows();
			// initializing tabArray with number of rows and maximum number of columns
			for (int r = 0; r < rows; r++) {
				int cells = ExcelWSheet.getRow(r).getPhysicalNumberOfCells();
				if (temp < cells) {
					temp = cells;
				}
			}
			// initializing
			tabArray = new Object[rows - 1][temp];
			// analyzing data in excel
			for (int r = 1; r < rows; r++) {
				// make sure row is valid
				row = ExcelWSheet.getRow(r);
				if (row != null) {
					// get number of cells in row
					int cells = ExcelWSheet.getRow(r).getPhysicalNumberOfCells();
					for (int c = 0; c < cells; c++) {
						Cell = row.getCell(c);
						if (Cell != null) {
							// add string value in cell to tabArray	
							tabArray[r - 1][c] = Cell.getStringCellValue();
						}
					}
				}

			}
		} catch (Exception e) {
			System.out.println("Failure during attempt to read Excel file:");
			e.printStackTrace();
		}
		return tabArray;
	}
}

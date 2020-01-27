package com.app.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {

	/* To get the Total number of rows(data filled rows) in the sheet */
	public int getExcelRowCount(String xlPath, String sheetName) {

		int iRowNum = -1;
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			iRowNum = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iRowNum;
	}

	/* To Read the data from the cell */
	public String getExcelData(String xlPath, String sheetName, int rowNo, int cellNo) {

		String data = "";
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			data = sht.getRow(rowNo).getCell(cellNo).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/* To get the Number of columns from the Each row */
	public int getExcelCellCount(String xlPath, String sheetName, int rowNo) {

		int cellCount = 0;
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sht = wb.getSheet(sheetName);
			cellCount = sht.getRow(rowNo).getLastCellNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellCount;
	}
	
	/* To write the data to the cell */
	public void setExcelData(String xlPath, String sheetName, int rowNo, int cellNo, String value) {
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = (Workbook) WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet(sheetName);
			Row row = sheet.getRow(rowNo);
//			data = sht.getRow(rowNo).getCell(cellNo).toString();
			Cell cell = row.getCell(cellNo);
			//cell = row.createCell(cellNo);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cell.setCellValue(value);
			FileOutputStream fileOut = new FileOutputStream(xlPath);
			wb.write(fileOut);
			fileOut.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
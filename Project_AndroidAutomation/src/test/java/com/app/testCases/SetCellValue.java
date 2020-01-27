package com.app.testCases;

import org.testng.annotations.Test;

import com.app.generic.BaseTest;

public class SetCellValue extends BaseTest{
	
	@Test
	public void setValue() {
		ExcelLibrary.setExcelData(XLPath, "sheet01", 1, 1, "Hello");
	}

}

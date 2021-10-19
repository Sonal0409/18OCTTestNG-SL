package com.qa.testNgParameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Xls_dataProvidernew {
	
	static Workbook book;
	static Sheet sheet;
	
	public static String testdata_sheet_path="C:\\Users\\sonal\\Desktop\\Excels\\TestData.xlsx";
	
	public static Object[][] ReadExcel(String sheetName) 
	{
		// Give location of your excel file with data
		
		FileInputStream file =null;
		
		try {
			file = new FileInputStream(testdata_sheet_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// fetch the excel sheet - WorkBook
		
	   try {
		book = WorkbookFactory.create(file);
	} catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		// Select the sheet from the excel
		
		sheet = book.getSheet(sheetName);
		// count number of rows that has data
		int row = sheet.getLastRowNum();
		// count number of columns that have data
		int col = sheet.getRow(0).getLastCellNum();
		// Array which will store all of the values of excel
		Object [][] inputData = new Object[row][col];
		
// Start a for loop to go to each row, each column and fetch the cell data
		for(int i=0;i<row;i++)
		{
			for(int j=0;i<col;j++)
			{
				inputData [i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		// once you have cell data for all the rows and all the columns, return it to your testmethod
		
		return inputData;
	}

}

package com.qa.demoshop.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtility {
	
	public static FileInputStream fis;
	public static XSSFWorkbook book; //poi-ooxml, poi
	public static XSSFSheet sheet;
	public static XSSFRow Row;
	public static XSSFCell Cell;
	
	public static String getData(String registerExcelPath,String sheetName, int row , int cell) throws IOException {
		fis=new FileInputStream(registerExcelPath);
		book=new XSSFWorkbook(fis);
		sheet=book.getSheet(sheetName);
		Row=sheet.getRow(row);
		Cell=Row.getCell(cell);
		//return Cell.getStringCellValue();
		return Cell.getStringCellValue();
	}
	
	public static int getLastRowNumber(String registerExcelPath,String sheetName) throws IOException{
		fis=new FileInputStream(registerExcelPath);
		return new XSSFWorkbook(fis).getSheet(sheetName).getLastRowNum();
			
	}
	
	public static int getLastCellNumber(String registerExcelPath,String sheetName, int row) throws IOException{
		fis=new FileInputStream(registerExcelPath);
		return new XSSFWorkbook(fis).getSheet(sheetName).getRow(row).getLastCellNum();		
	}
}

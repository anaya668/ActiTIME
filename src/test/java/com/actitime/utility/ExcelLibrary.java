package com.actitime.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary implements AutoConstant
{
	public static String getStringDataFromExcel(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		String cellvalue=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return cellvalue;
	}
	public static boolean getBooleanDataFromExcel(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		boolean cellvalue=wb.getSheet(sheet).getRow(row).getCell(cell).getBooleanCellValue();
		return cellvalue;
	}
	public static double getnumericDataFromExcel(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		double cellvalue=wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
		return cellvalue;
	}
	public static Date getDateDataFromExcel(String sheet , int row , int cell) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		Date cellvalue = wb.getSheet(sheet).getRow(row).getCell(cell).getDateCellValue();
		return cellvalue;
	}
	public static int rowCount(String sheet) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		int rowCount = wb.getSheet(sheet).getLastRowNum();
		return rowCount;
	}
	public static void cellCount(String sheet) throws IOException
	{
		FileInputStream fis=new FileInputStream(excel_path);
		Workbook wb=new XSSFWorkbook(fis);
		for(int i=0;i<=wb.getSheet(sheet).getLastRowNum();i++)
		{
			short cellCount = wb.getSheet(sheet).getRow(i).getLastCellNum(); 
			System.out.println("number of cells present in " +i+ "row " +"is :" +cellCount);
		}
	}
}
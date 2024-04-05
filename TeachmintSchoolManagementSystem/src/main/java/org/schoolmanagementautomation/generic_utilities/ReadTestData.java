package org.schoolmanagementautomation.generic_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTestData implements FrameworkConstants{
	
	// generic methods to intract with test resources from property and excel file
	
	public File absPath = new File(EXCEL_PATH);
	public Workbook wb = null;
	
	
	public double readNumberDataFromExcel(String sheetName, int rowNum, int cellNum) {
		try {
			FileInputStream fis = new FileInputStream(absPath);
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}
	
	public String readStringDataFromExcel(String sheetName, int rowNum, int cellCount) {

		try {
			FileInputStream fis = new FileInputStream(absPath);
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		  Sheet sheet = wb.getSheet(sheetName);
          Row row = sheet.getRow(rowNum);
          Cell cell = row.getCell(cellCount);
          
          String data=null;
          
			if(cell.getCellType()==cell.getCellType().STRING)
			{
				data=cell.getStringCellValue();
			}
			else if(cell.getCellType()==cell.getCellType().NUMERIC)
			{
				
				data=String.valueOf(cell.getNumericCellValue());
			}
			return data;
      
	}
	
	public Date readDateDataFromExecl(String sheetName, int rowNum, int cellCount) {

		try {
			FileInputStream fis = new FileInputStream(absPath);
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellCount).getDateCellValue();
	}
	
	
	public String readAnyDataFromExcelInString(String sheetName,int rowNum,int cellNum)
	{
	  File absPath=new File(EXCEL_PATH);
	  Workbook wb=null;
	  
	  
	  try {
		FileInputStream fis = new FileInputStream(absPath);  
		wb=WorkbookFactory.create(fis);
	} catch (EncryptedDocumentException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	  
	  return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
	  
	}
	
	
	public String readDataFromPropertyFile(String key) throws ReadPropertyFileDataException {

		File absPath;
		FileInputStream fis;
		Properties properties = null;
		try {
			absPath = new File(PROPERTY_PATH);
			fis = new FileInputStream(absPath);
			properties = new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
	
	
	//***************************************CustomeException**********************************
	
	@SuppressWarnings("serial")
	public class ReadPropertyFileDataException extends Exception{
		
		public ReadPropertyFileDataException()
		{
			super("Check for the property file path!!!");
		}
	}

}

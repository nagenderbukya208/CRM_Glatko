package com.comcast.hrm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String getDataFromExcel(String sheetname, int rownum, int celnum) throws Throwable {
	FileInputStream fis= new FileInputStream("./commonData/ngdr1.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh= wb.getSheet(sheetname);
	Row row= sh.getRow(rownum);
	String data= row.getCell(celnum).toString();
	return data;
}
public int getRowCount(String sheetname) throws Throwable {
	FileInputStream fis= new FileInputStream("./commonData/ngdr1.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh= wb.getSheet(sheetname);
	int row= sh.getLastRowNum();
	return row;
}
public void setDataIntoExcel(String sheetname,int rownum,int celnum, String data) throws Throwable {
	FileInputStream fis= new FileInputStream("./commonData/ngdr1.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	wb.getSheet(sheetname).getRow(rownum).createCell(celnum).setCellValue(data);
FileOutputStream fos= new FileOutputStream("./commonData/ngdr1.xlsx");
wb.write(fos);
wb.close();
}
}

package com.zhongzheng.selenium.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import org.apache.poi.xssf.usermodel.*;

import com.google.common.collect.Table.Cell;

public class ExcelWorkBook {
	private XSSFSheet ExcelWSheet;
	private XSSFWorkbook ExcelWBook;
	public String number[]=new String[4];
	public String name[]=new String[4];
	public String date[]=new String[4];
	public String issuingAuthority[]=new String[4];
	public String address[]=new String[4];
	
	public void excelutils(String Path, String SheetName) throws Exception 
	   {		
		  try 
		  {
		   FileInputStream ExcelFile = new FileInputStream(Path);
		    ExcelWBook = new XSSFWorkbook(ExcelFile);
		    ExcelWSheet = ExcelWBook.getSheet(SheetName);		    
		  } 
		  catch (Exception e)
		  {
		    throw (e);           
		  }
		  
		  System.out.println("参数文件的地址:"+Path);

		  try{
			  for(int i=0;i<4;i++){
			  String CellData = ExcelWSheet.getRow(i+1).getCell(0).getStringCellValue();
			  String CellData1 = ExcelWSheet.getRow(i+1).getCell(1).getStringCellValue();
			  String CellData2 = ExcelWSheet.getRow(i+1).getCell(2).getStringCellValue();
			  String CellData3 = ExcelWSheet.getRow(i+1).getCell(3).getStringCellValue();
			  String CellData4 = ExcelWSheet.getRow(i+1).getCell(4).getStringCellValue();

			  number[i]=CellData;
			  name[i]=CellData1;
			  date[i]=CellData2;
			  issuingAuthority[i]=CellData3;
			  address[i]=CellData4;
			  }
		  }
		  catch (Exception e)
		  {
		    throw (e);           
		  }
/*		  for(int i=number.length-1;i>=0;i--){
			  System.out.println("第一列的内容：" + number[i]);
			  System.out.println("第二列的内容：" +  name[i]);
			  System.out.println("第三列的内容：" + date[i]);
			  System.out.println("第四列的内容：" +  issuingAuthority[i]);
			  System.out.println("第五列的内容：" + address[i]);
		  }*/
	   }

}

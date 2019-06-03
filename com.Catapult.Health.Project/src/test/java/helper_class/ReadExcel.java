package helper_class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ReadExcel 
{
	public static File FileExcel;
	public static String pathExcel ;
	public static FileInputStream inputstreamExcel  =null;
	public static XSSFWorkbook workbookExcel =null;
	public static XSSFSheet XSSFSheetExcel =null;
	public static XSSFRow RowExcel ;
	public static XSSFCell CellExcel ;
	public Cell cellExcel ;
	public static Row rowExcel ;
	public static FileOutputStream FileOutputStreamExcel ;
	
	
	public ReadExcel(String pathExcel) throws IOException {
		
		try 
		{
			FileExcel = new File(pathExcel);
			inputstreamExcel = new FileInputStream(FileExcel);
			workbookExcel =new XSSFWorkbook(inputstreamExcel);
			
			
		} 
		catch (FileNotFoundException e) 
		{	
			System.out.println(e.getMessage());
		}
		
	}
	
	//write test case name to excel
	public static void write_test_case_name_to_excel(String SheetName, int RowNum, int ColumnNum) 
	{
		
		try 
		{
			XSSFSheetExcel = workbookExcel.getSheet(SheetName);	
			XSSFSheetExcel.getRow(RowNum).createCell(ColumnNum).setCellValue("test result");
			FileOutputStreamExcel = new FileOutputStream(FileExcel);
			workbookExcel.write(FileOutputStreamExcel);
			
		} 
		
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}

	}

	
	
	public static void write_result_to_excel(String SheetName, int RowNum, int ColumnNum, String result) 
	{
		
		try 
		{
			XSSFSheetExcel = workbookExcel.getSheet(SheetName);	
			XSSFSheetExcel.getRow(RowNum).createCell(ColumnNum).setCellValue(result);
			FileOutputStreamExcel = new FileOutputStream(FileExcel);
			workbookExcel.write(FileOutputStreamExcel);
			
		} 
		
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}

	}



	//find the row number of the defined test case in the defined sheet 
    public static int getRowContains(String sheetname, String testcasename, int colnum) 
    {
	     int i;
	     XSSFSheetExcel=workbookExcel.getSheet(sheetname);
	     int row_count=XSSFSheetExcel.getLastRowNum();
	     for(i=0;i<row_count; i++) 
	     {
	    	 if(XSSFSheetExcel.getRow(i).getCell(colnum).getStringCellValue().contains(testcasename)) 
	    	 {
	    		 break;
	    	 }
	     }
	    return i;
    }

	
	
	
	//set result upon parameritize rownum
	  public static void setcelldata(String sheetname, String ColName, String data, int rowNum) throws FileNotFoundException {
			 try 
			 {
				 int col_num=-1;
				 
				 //identify if any sheet exist
				 int index=workbookExcel.getSheetIndex(sheetname);
				 if(index==-1)
				 {
					 System.out.println("Excel sheet does not exist");
				 }	 
				 
				 
				 //identify if excel has data
				 XSSFSheetExcel= workbookExcel.getSheet(sheetname);
				 if(rowNum<=0) 
				 {
					 System.out.println("Excel has no data");
				 }

				 XSSFSheetExcel=workbookExcel.getSheetAt(index);
				 RowExcel=XSSFSheetExcel.getRow(0);
			  
				 if(col_num==-1)
				 {
					 System.out.println("Excel has no data");
			     }
				 else
				 {
					 for(int i=0; i<RowExcel.getLastCellNum();i++) 
					 {
						 System.out.println(RowExcel.getCell(i).getStringCellValue().trim());
						 if(RowExcel.getCell(i).getStringCellValue().trim().equalsIgnoreCase(ColName))
						 {
							 col_num=i;
						 }
						
					 }
				 }

				 XSSFSheetExcel.autoSizeColumn(col_num);
				 RowExcel=XSSFSheetExcel.getRow(rowNum-1);
				 CellExcel=RowExcel.getCell(col_num);
				 
				 if(CellExcel==null)
				 {
					 CellExcel=RowExcel.createCell(col_num);
				 }
				
				 CellExcel.setCellValue(data);
				 FileOutputStreamExcel = new FileOutputStream(FileExcel);
				 workbookExcel.write(FileOutputStreamExcel);
				 
				 
			   } 
			 
			 	catch (IOException e) 
			 	{
				
				System.out.println(e.getMessage());
				}

			
			}


}

package base_class;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import helper_class.ReadExcel;




public class Base_class 
{


    public static Properties prop;
    public static FileInputStream fils;
    static File file1;
    public static ReadExcel readexcel;

    ITestResult result;
	
	@BeforeTest
	public static void getData() 
	{
		try {
				//loading the properties file
				prop = new Properties();
				fils = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\utilities\\CatapultHealth.properties");
				prop.load(fils);
				System.out.println("Config properties file is loaded");
				
				//loading the excel file
				readexcel= new ReadExcel(System.getProperty("user.dir")+"\\src\\test\\java\\excel\\CatapultHealth_TestCases.xlsx");
				System.out.println("Excel file is loaded");		
				
			} 
		
		catch (Exception e) 
			{
				e.getMessage();
			}

	}
	
	

	
	  public void getResult(ITestResult result) throws IOException
	  {

		  if(result.getStatus()==ITestResult.SUCCESS) 
		  {
			  System.out.println("test case is passed "+result.getName());
			  ReadExcel.write_result_to_excel(prop.getProperty("Testing_sheet_name"), ReadExcel.getRowContains(prop.getProperty("Testing_sheet_name"), result.getName(),0), 1,"Passed");
			  
		  }

		
		  else if(result.getStatus()==ITestResult.FAILURE) 
		  {
			  System.out.println("Failed test case name is:  "+result.getName());
			  ReadExcel.write_result_to_excel(prop.getProperty("Testing_sheet_name"), ReadExcel.getRowContains(prop.getProperty("Testing_sheet_name"), result.getName(),0), 1,"Failed");
			  
		  }
		  
		  else  
		  {
			  System.out.println("test is skiped"+result.getName());
			  ReadExcel.write_result_to_excel(prop.getProperty("Testing_sheet_name"), ReadExcel.getRowContains(prop.getProperty("Testing_sheet_name"), result.getName(),0), 1,"Skip");
			  
		  }
	  }
	
	//calling getResult Method
	  @AfterMethod
	  public void aftermethod(ITestResult result) throws IOException 
	  {
		  getResult(result);
	  }
		
	  
	  
	  
	  
	  
	
	
	
	
	
	
}

package catapult_Health_test_case;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import base_class.Base_class;
import helper_class.ReadExcel;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Resources;
import utilities.Resources_data;

public class Create_Dictionary extends Base_class
{
	

	public static String pathExcel ;
	public static FileInputStream inputstreamExcel  =null;
	public static XSSFWorkbook workbookExcel =null;
	public static XSSFSheet XSSFSheetExcel =null;
	public static XSSFRow RowExcel ;
	public static XSSFCell CellExcel ;
	public Cell cellExcel ;
	public static Row rowExcel ;
	public static FileOutputStream FileOutputStreamExcel ;
	
	


	@Test
	public void CreateDictionary()
	{

		baseURI = prop.getProperty("HOST_CatapultHealth");
		
		Response res =
		given().
				header("Content-Type", "application/json").
				header("Authorization", prop.getProperty("Authorization_value") ).
	       		//log().all(). //log all the stuff
	    when().
	       		post(Resources.create_new_dictionary()).
	    then().
	    		assertThat().statusCode(201).
	    		//log().body().  //get everything of the body
	    		extract().response();
		
		JsonPath js = Resources.rawToJSON(res);
		
		String id = js.get("id");
		
		System.out.println("Dictionary ID ====" + id);
	
		
	}
	
	
	
}

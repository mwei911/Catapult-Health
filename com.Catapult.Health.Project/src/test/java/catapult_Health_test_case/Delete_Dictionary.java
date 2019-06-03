package catapult_Health_test_case;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import base_class.Base_class;
import helper_class.ReadExcel;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Resources;
import utilities.Resources_data;

public class Delete_Dictionary extends Base_class
{
	

	

	//delete a dictionary 
	@Test
	public void DeleteDictionary()
	{

		baseURI = prop.getProperty("HOST_CatapultHealth");
		

		given().
				header("Content-Type", "application/json").
				header("Authorization", prop.getProperty("Authorization_value") ).
	       		//log().all(). //log all the stuff
	    when().
	       		delete(Resources.delete_dictionary()).
	    then().
	    		assertThat().statusCode(204).
	    		//log().body().  //get everything of the body
	    		extract().response();
	
		
	}
	
	
	
}

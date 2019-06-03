package catapult_Health_test_case;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base_class.Base_class;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Resources;
import utilities.Resources_data;

public class Create_Key_Value_Pair extends Base_class
{
	

	
	@Test(dataProvider = "data-provider", dataProviderClass = Resources_data.class)
	public void create_key_value_pair(String keyvalue)
	{

		baseURI = prop.getProperty("HOST_CatapultHealth");
		

		given().
				header("Content-Type", "application/json").
				header("Authorization", prop.getProperty("Authorization_value") ).
				body(Resources_data.create_pair_key_value_data()).
				log().all(). 
	    when().
	       		post(Resources.create_key_value_pair(keyvalue)).
	    then().
	    		assertThat().statusCode(200).
	    		//log().body().  
	    		extract().response();

	}
	
	

	
	
}

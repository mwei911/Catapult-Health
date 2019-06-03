package helper_class;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import base_class.Base_class;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Resources;
import utilities.Resources_data;

public class Helper_class extends Base_class
{

	
	public static String Create_new_library_method()
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
		
		String id = Resources.rawToJSON(res).get("id");
		
		return id;
	}
	
	
	public void Delete_library_method(String id)
	{

		baseURI = prop.getProperty("HOST_CatapultHealth");
		

		given().
				header("Content-Type", "application/json").
				header("Authorization", prop.getProperty("Authorization_value") ).
	       		log().all(). //log all the stuff
	    when().
	       		delete(Resources.delete_dictionary(id)).
	    then().
	    		assertThat().statusCode(204).
	    		log().body().  //get everything of the body
	    		extract().response();
	
		
	}
	
	
	public static void created_new_library_and_new_key_method(String id, String keyvalue)
	{
		
		baseURI = prop.getProperty("HOST_CatapultHealth");
		
		Response res=
		given().
				header("Content-Type", "application/json").
				header("Authorization", prop.getProperty("Authorization_value") ).
				body(Resources_data.create_pair_key_value_data()).
				log().all(). 
	    when().
	       		post(Resources.create_key_value_pair(id, keyvalue)).
	    then().
	    		assertThat().statusCode(200).
	    		//log().all().  
	    		extract().response();	

	}
	
	
	public static void Get_All_Keys_method(String id)
	{

		baseURI = prop.getProperty("HOST_CatapultHealth");

		given().
				header("Content-Type", "application/json").
				header("Authorization", prop.getProperty("Authorization_value") ).
	       		log().all(). 
	    when().
	       		get("/dictionary/"+ id +"/keys").
	    then().
	    		assertThat().statusCode(200).
	    		log().body().  
	    		extract().response();

	}
	
	
	
}

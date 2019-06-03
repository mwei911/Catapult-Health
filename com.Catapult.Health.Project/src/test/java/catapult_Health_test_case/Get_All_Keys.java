package catapult_Health_test_case;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import base_class.Base_class;
import helper_class.Helper_class;
import utilities.Resources;
import utilities.Resources_data;


public class Get_All_Keys extends Base_class
{
	
	@Test(dataProvider = "data-provider", dataProviderClass = Resources_data.class)
	public static void test(String keyvalue)
	{
		
		String test_id = Helper_class.Create_new_library_method();
		
		System.out.println("test_id:::::" + test_id);

		//create key value
		
		Helper_class.created_new_library_and_new_key_method(test_id, keyvalue);
		
		//find all key value
		
		Helper_class.Get_All_Keys_method(test_id);
    }
	
	
	
}

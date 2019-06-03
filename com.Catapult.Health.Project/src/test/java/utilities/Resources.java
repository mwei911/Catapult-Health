package utilities;

import helper_class.Helper_class;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


public class Resources 
{

	public static String create_new_dictionary()
	{
		
		String data = "/dictionary";
		return data;
		
	}
	
	
	public static String delete_dictionary()
	{
		
		String data = "/dictionary/"+ Helper_class.Create_new_library_method();
		return data;
		
	}
	
	public static String delete_dictionary(String id)
	{
		
		String data = "/dictionary/"+ id;
		return data;
		
	}
	

	public static String create_key_value_pair(String key)
	{
		
		String data = "/dictionary/"+Helper_class.Create_new_library_method()+ "/keys/"+key;
		return data;
		
	}
	
	public static String create_key_value_pair(String id, String key)
	{
		
		String data = "/dictionary/"+id+ "/keys/"+key;
		return data;
		
	}
	
	
	
	
	public static String get_all_keys(String id)
	{
		
		String data = "/dictionary/"+id+ "/keys";
		return data;
		
	}
	
	public static String get_all_keys()
	{
		
		String data = "/dictionary/"+ Helper_class.Create_new_library_method()+ "/keys";
		return data;
		
	}
	
	
	
	
	
	

	public static JsonPath rawToJSON (Response res)
	{
		
		String responseString = res.asString();
		
		JsonPath js = new JsonPath(responseString);  //read the string and convert to JSON because original is raw format
		
		return js;
		
	}
	
	
	public static XmlPath rawToXML (Response res)
	{
		
		String responseString = res.asString();
		
		XmlPath xml = new XmlPath(responseString);  //read the string and convert to JSON because original is raw format
		
		return xml;
		
	}
	
	




	
	
	
}

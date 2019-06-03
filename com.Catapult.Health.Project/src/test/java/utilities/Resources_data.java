package utilities;

import org.testng.annotations.DataProvider;

public class Resources_data 
{

	public static String create_pair_key_value_data()
	{
		
		String data = 

				"{"+
						"\"value\" : \"test all key value\" }"
				
				;
		
		return data;
		
		
	}


	public static String modify_pair_key_value_data(String input_modify_data)
	{
		
		String data = 

				"{"+
						"\"value\" : \""+input_modify_data+"\" }"+
				"}"
				
				;
		
		return data;
		
		
	}

	
    @DataProvider(name = "data-provider")
    public static Object[][] dataProvider_Method()
    {
        return new Object[][] { { "testkey1" }, { "testkey2" } };
    }
	
	
	
}

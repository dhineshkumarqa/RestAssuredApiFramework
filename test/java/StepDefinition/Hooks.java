package StepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks 
{
	@Before("@deleteplace")
	public void RunBefore() throws IOException
	{

		
		Step m = new Step();
		if(Step.Place_id == null)
		{
		m.add_place_api_with("Dhinesh", "French", "23,american street", "https://www.freeformatter.com/");
		m.user_calls_the_api_using_method("Addplace", "POST");
		m.verify_the_place_id_created_map_to_using("Dhinesh", "getplace");
		}
				
	}

}

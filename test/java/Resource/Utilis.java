package Resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilis {
	public static RequestSpecification header;

	public RequestSpecification requestSpecification() throws IOException {
		
		if(header == null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		RestAssured.useRelaxedHTTPSValidation();
		header = new RequestSpecBuilder().setBaseUri(GlobalVariable("baseUri"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return header;
		}
		return header;
	}
   
	public static String GlobalVariable(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\DHISRINI\\OneDrive - Capgemini\\Documents\\Selenium\\RestassuredApiFramework\\src\\test\\java\\Resource\\Global.properties");
		prop.load(file);
		return prop.getProperty(key);
	}
	
	public String getApivalue(Response asString, String key)
	{
		String asString2 = asString.asString();
		JsonPath js = new JsonPath(asString2);
		return js.get(key).toString();
	}
}

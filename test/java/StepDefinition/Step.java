package StepDefinition;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resource.APIresource;
import Resource.TestData;
import Resource.Utilis;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step extends Utilis {
	RequestSpecification response;
	ResponseSpecification responseSpecification;
	Response asString;
	static String Place_id;

	@Given("Add place Api with {string} {string} {string} {string}")
	public void add_place_api_with(String name, String language, String Address, String website) throws IOException {

		TestData ts = new TestData();
		response = given().spec(requestSpecification()).body(ts.testdata(name,language,Address,website));
	}

	@When("user calls the {string} api using {string} method")
	public void user_calls_the_api_using_method(String resource, String method) 
	{
		APIresource Addapi = APIresource.valueOf(resource);
		System.out.println(Addapi.getresource());
		responseSpecification = new ResponseSpecBuilder().expectContentType("application/json").build();
		if(method.equalsIgnoreCase("POST"))
		{
		asString = response.when().post(Addapi.getresource())
				.then().spec(responseSpecification).log().all().extract().response();
		}
		else if(method.equalsIgnoreCase("GET"))
		{
		asString = response.when().get(Addapi.getresource())
				.then().spec(responseSpecification).log().all().extract().response();	
		}
	}

	@Then("verify the status code")
	public void verify_the_status_code() {

		Assert.assertEquals(asString.statusCode(), 200);
	}

	@And("{string} verify the value  is {string}")
	public void verify_the_value_is(String key, String string2) {
		
		Assert.assertEquals(getApivalue(asString,key), string2);
	}
	
	@Then("verify the place_id created map to {string} using {string}")
	public void verify_the_place_id_created_map_to_using(String expectedname, String string2) throws IOException {
	    
		Place_id = getApivalue(asString,"place_id");
		System.out.println(Place_id);
		response = given().spec(requestSpecification()).queryParam("place_id", Place_id);
		user_calls_the_api_using_method(string2, "GET");
		String actualname = getApivalue(asString,"name");
		Assert.assertEquals(actualname, expectedname);
		Assert.assertEquals(asString.statusCode(), 200);
	
	}
	
	@Given("delete playload")
	public void delete_playload() throws IOException 
	{
		response = given().spec(requestSpecification()).body(TestData.deleteplaceApi(Place_id));
	}

	

}

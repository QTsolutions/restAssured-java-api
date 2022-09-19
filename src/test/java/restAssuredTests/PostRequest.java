package restAssuredTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

public class PostRequest {

	@Test
	public void postData()
	{

//		RestAssured.baseURI ="https://demoqa.com/customer";
//		RequestSpecification request = RestAssured.given();
//
//		JSONObject requestParams = new JSONObject();
//		requestParams.put("FirstName", "Virender"); // Cast
//		requestParams.put("LastName", "Singh");
//		requestParams.put("UserName", "sdimpleuser2dd2011");
//		requestParams.put("Password", "password1");	
//		requestParams.put("Email",  "sample2ee26d9@gmail.com");
//
//		request.body(requestParams.toJSONString());
//		Response response = request.post("/register");
//
//		int statusCode = response.getStatusCode();
//		System.out.println("The status code recieved: " + statusCode);
//
//		System.out.println("Response body: " + response.getBody().asString());
//
//		//Assertion
//		Assert.assertEquals(statusCode, 201);
		
		RestAssured.baseURI ="https://reqres.in/api";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", "Siddharth"); // Cast
		requestParams.put("job", "Tester");

		request.body(requestParams.toJSONString());
		Response response = request.post("/users");
	

		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.getBody().asString());

		//Assertion
		Assert.assertEquals(statusCode, 201);
		
		

		
			}
}

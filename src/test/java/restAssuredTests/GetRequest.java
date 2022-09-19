package restAssuredTests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.*;

public class GetRequest {

//	@Test
	public void getDetails() {
		
		given()
		.when()
			.get("http://dummy.restapiexample.com/api/v1/employees")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("status",equalTo("success"))
			.header("Content-Type","application/json");
		
	} 
			
	@Test
	public void getWeather() {
//		String city= "Hyderabad";
		//Specify base URI
		RestAssured.baseURI= "http://demoqa.com/utilities/weather/city/";
		
		//Request Object 
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object 
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody= response.getBody().asPrettyString();
//		System.out.println(responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		System.out.println("Status Code :" + statusCode);
		System.out.println("Body : "+ response.getBody());
		System.out.println("Content Type : " + response.getContentType());
		System.out.println("Headers: " + response.getHeaders());
		System.out.println("Time :" + response.getTime());
		System.out.println("StatusLine : "+ statusLine); 
		//Assertions 
		Assert.assertEquals(responseBody.contains("Hyderabad") , true, "Response body contains Hyderabad");
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		//VerifyCityInJsonResponse
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String city = jsonPathEvaluator.get("City");

		// Let us print the city variable to see what we got
		System.out.println("City received from Response " + city);

		// Validate the response
		Assert.assertEquals(city, "Hyderabad", "Incorrect city name received in the Response");
		} 
	
//	@Test
//	void googleMapTest() {
//		RestAssured.baseURI = "https://maps.googleapis.com";
//		RequestSpecification httpRequest = RestAssured.given();
//	Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyDs8KTHgF88LBarQtvuRD2g82AhJo2DFHk");
//	
//	String responseBody = response.getBody().asString();
//	System.out.println("Response Body " + responseBody);
//		
//	} 
}

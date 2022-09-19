package restAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {
@Test
	void deleteEmployee()
	{
		int empid = 8829;
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
			
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");	
		
	   // Delete the request and check the response
//		Response response = httpRequest.request(Method.GET,"/");
		Response response = httpRequest.delete("/delete/"+ empid);
			
			
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
			
		String jsonString =response.getBody().asPrettyString();
		System.out.println("Response Body:"+ response.getBody().asString());
		Assert.assertEquals(jsonString.contains("Successfully! Record has been deleted"), true);
	}
}

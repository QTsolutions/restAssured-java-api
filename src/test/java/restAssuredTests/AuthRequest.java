package restAssuredTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthRequest {

	@Test
	void authorization() {

		RestAssured.baseURI = "https://demoqa.com/authentication/CheckForAuthentication";


		//BasicAuth 
		PreemptiveBasicAuthScheme authScheme =  new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");
		RestAssured.authentication = authScheme;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/");

		int statusCode = response.getStatusCode();
		System.out.println("StatusCode :" + statusCode);
		//String responseBody = response.getBody().asString();
		System.out.println("Response Body: "+ response.getBody().asString());

		Assert.assertEquals(statusCode,200);

	}
}

package restAssuredTests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {

	@Test
	void updateEmployee() {
		int empId = 8829;
	
	RestAssured.baseURI ="https://dummy.restapiexample.com/api/v1";
	RequestSpecification request = RestAssured.given();
	
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("name", "Zion"); // Cast
	requestParams.put("age", 23);
	requestParams.put("salary", 12000);

	request.body(requestParams.toJSONString());
	Response response = request.put("/update/"+ empId);

	int statusCode = response.getStatusCode();
	System.out.println("Status code >>>>>>>"+ statusCode);
	System.out.println("REsponse body:" + response.getBody().asPrettyString());
	Assert.assertEquals(statusCode, 200); 
	String jsonString =response.getBody().asPrettyString();
	System.out.println("Response Body:"+ response.getBody().asString());
	Assert.assertEquals(jsonString.contains("Successfully! Record has been updated."), true);
	}
}

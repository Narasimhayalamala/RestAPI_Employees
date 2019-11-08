package com.employesApi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeApi.Base.testBase;
import com.utilities.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_Put_Employee_Record extends testBase {
	
	RequestSpecification httpRequest;
	Response response;
	String empName=RestUtil.empName();
	String empSalary=RestUtil.empSal();
	String empAge=RestUtil.empAge();
	
	
	/******************************************************
	Test Name:Update an employee record
	URI: http://dummy.restapiexample.com/api/v1/update/{id}
	Request Type: PUT
	Request Payload(Body): {"name":"XXXXX","salary":"XXXX","age":"XX"}
	********* Validations **********
	Response Payload(Body) : {"name":"XXXXX","salary":"XXXX","age":"XX"}
	Status Code : 200
	Status Line : HTTP/1.1 200 OK
	Content Type : text/html; charset=UTF-8
	Server Type :  nginx/1.14.1
	Content Encoding : gzip
	 * @throws InterruptedException 
	**********************************************************/
@BeforeClass
 void updateEmployee() throws InterruptedException {
	 
	 logger.info("*********Started TC004_Put_Employee_Record **********");
		
	 RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	 
		httpRequest=RestAssured.given();
		
		JSONObject params=new JSONObject();
		params.put("name", empName);
		params.put("salary",empSalary);
		params.put("age",empAge);
		
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(params.toJSONString());
		response = httpRequest.request(Method.PUT,"/update/"+empID);
		Thread.sleep(5000);
		
 }
 @Test
	void checkResposeBody()
	{
		String responseBody = response.getBody().asString();
				
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSalary), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
	}
		
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 200);
	}
		
	@Test
	void checkstatusLine()
	{
		String statusLine = response.getStatusLine(); // Gettng status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	void checkContentType()
	{
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test
	void checkserverType()
	{
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "nginx/1.16.0");
	}

	@Test
	void checkcontentEncoding()
	{
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(contentEncoding, "gzip");

	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC004_Put_Employee_Record **********");
	}

}

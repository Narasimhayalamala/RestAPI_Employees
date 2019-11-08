package com.employeeApi.Base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testBase {
	
	public static RequestSpecification httpRequest;
	
	public static Response response;
	
	public String empID="9429";//
	
	public Logger logger;
	
	@BeforeClass
	
	public void setUp() {
		
		logger=Logger.getLogger("EmployeeRestAPI");
		PropertyConfigurator.configure("Log4J.properties");
		logger.setLevel(Level.DEBUG);
	}
	

}

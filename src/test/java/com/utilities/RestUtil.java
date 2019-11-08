package com.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {
	
	public static String empName() {
		 String generatedString=RandomStringUtils.randomAlphabetic(2);
		return ("john"+generatedString);
	}
	
	public static String empSal() {
		
		String generatedString=RandomStringUtils.randomAlphanumeric(5);
		return generatedString;
	}
public static String empAge() {
		
		String generatedString=RandomStringUtils.randomAlphanumeric(2);
		return generatedString;
		}

}

package com.qa.rest.tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.baseURI;;

public class SoapXMLRequest {
	
	@Test
	public void validateSoapXML() throws IOException {
		
		File file = new File("./SOAPRequest/Add.xml");
		
		FileInputStream ip = new FileInputStream(file);
        
		String requestBody = IOUtils.toString(ip, "UTF-8"); //need to add apache commons io dependency
		
		baseURI = "http://www.dneonline.com";
		
		given().
		config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("text-xml", ContentType.TEXT))).
			contentType("text-xml").
			accept(ContentType.XML).
			body(requestBody).
		when()
			.post("/calculator.asmx").
		then()
		.statusCode(200);

	}

	private EncoderConfig encoderConfig() {
		// TODO Auto-generated method stub
		return null;
	}


}

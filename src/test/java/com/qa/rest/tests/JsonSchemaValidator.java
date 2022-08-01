package com.qa.rest.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JsonSchemaValidator {

	
	    @Test
		public void testGet() {
			
			baseURI = "https://reqres.in/api";
			given().
		     get("/users?page=2").
		    then().
		    assertThat().body(matchesJsonSchemaInClasspath("Schema.json")).
		     statusCode(200);
		}
}

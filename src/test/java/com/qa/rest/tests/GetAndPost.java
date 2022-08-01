package com.qa.rest.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetAndPost {
	
	
	//@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		given().
	     get("/users?page=2").
	    then().
	     statusCode(200).
	     body("data[4].first_name", equalTo("George")).
	     body("data.first_name", hasItems("George", "Rachel"));
		
	}
	
	@Test
	public void testPost() {
		
		
		Map<String, String> map = new HashMap<String, String>();
		//map.put("name", "Raghav");
		//map.put("job", "Teacher");
		//System.out.println(map);
		
		//need to add JSON library (dependency) here: I added JSON simple by google.
		//need to convert payload into JSON form for POST request.
		
		JSONObject request = new JSONObject(map);
		
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
		    header("Content-Type","application-json").
		    contentType(ContentType.JSON).
		    accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
	}
	
	
	
	
	
	
	
	

}

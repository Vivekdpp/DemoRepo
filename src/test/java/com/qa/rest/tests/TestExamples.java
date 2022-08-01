package com.qa.rest.tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class TestExamples {
	
	@Test
	public void test_1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
           }
	
	@Test
	public void test_2() {
		
		baseURI = "https://reqres.in/api";
		given().
		     get("/users?page=2").
		then().
		     statusCode(200).
		     body("data[4].first_name", equalTo("George")).
		     body("data.first_name", hasItems("George", "Rachel"));
		  
		
	}
	
	
	
}

	
	
	
	
	
	
	/*given(). //NaveenAutomation
	when().
	      get("http://ergast.com/api/f1/2017/circuits.json").
	then().
	      assertThat().
	      
	      statusCode(200).
	      
	      and().
	      
	      body("MRData.CircuitTable.Circuits.circuitId",hasSize(20)).
	      
	      and().
	      
	      header("Content-Length", equalTo("4552"));
	      
	
	
	}*/
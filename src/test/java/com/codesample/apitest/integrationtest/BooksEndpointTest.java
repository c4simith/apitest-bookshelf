package com.codesample.apitest.integrationtest;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

@SpringBootTest
class BooksEndpointTest {

	@BeforeAll
	static void init() {
		baseURI = "http://localhost:8080";
	}
	
	@Test
	void test_getMethod() {
		
		given().
			get("/books").
		then().
			statusCode(200);
	}
	
	@Test
	void test_postMethod() throws JSONException {
		
		JSONObject book = new JSONObject("{ \"name\": \"TFIOS\",\"author\": \"John Green\", \"genre\": \"Fiction\"}");
		
		given().
			contentType(ContentType.JSON).body(book.toString()).post("/books").
		then().
			statusCode(200);
	}
}

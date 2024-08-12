package api.test;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.APIFunctions;
import api.endpoints.Endpoints;

import api.payload.User;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;



public class UserTests {

	@Test
	public void Getstatus() {

		APIFunctions API = new APIFunctions("baseUrl");
		System.out.println(baseURI);
		Response getRequest = API.getRequest("/status", null);
		getRequest.then().statusCode(200);
		System.out.println(getRequest.print());

	}

	@Test
	public void Getbookslist() {

		APIFunctions API = new APIFunctions("baseUrl");
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("type", "fiction");
		queryParams.put("limit", "2");
		Response getRequest = API.getRequest("/books", queryParams);
		getRequest.then().statusCode(200);
		System.out.println(getRequest.print());

	}

	@Test

	public void Responsevalidation() {
		APIFunctions API = new APIFunctions("baseUrl");
		
		String Jsonschema="{\r\n"
				+ " \r\n"
				+ "  \"type\": \"object\",\r\n"
				+ "  \"properties\": {\r\n"
				+ "    \"status\": {\r\n"
				+ "      \"type\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  },\r\n"
				+ "  \"required\": [\r\n"
				+ "    \"status\"\r\n"
				+ "  ]\r\n"
				+ "}";
		System.out.println(Jsonschema);
		API.APIResponseSchemavalidation("/status",Jsonschema);
		
		
	}
}
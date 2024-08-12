package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;

public class Endpoints {

	public static String Url(String url) {
		// Load JSON file
		File jsonFile = new File("C:\\RW_APPS\\RestAssuredAPITesting\\testdata\\config.json");

		// Parse JSON using JsonPath
		JsonPath jsonPath = new JsonPath(jsonFile);
		String baseUrl;

		// Get base URL from JSON
		baseUrl = jsonPath.getString(url);

		// Set base URI for RestAssured
		RestAssured.baseURI = baseUrl;
		

		return baseUrl;
	}

}

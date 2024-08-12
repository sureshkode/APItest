package api.endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class APIFunctions {

	public APIFunctions(String baseUrl) {
		// Calls a method 'Url' from the 'Endpoints' class with 'baseUrl', assigns the
		// result to 'Url'.
		String Url = Endpoints.Url(baseUrl);
		// Sets the base URI for RestAssured to the 'Url' obtained from the 'Endpoints'
		// class.
		RestAssured.baseURI = Url;
	}

	// GET request
	/**
	 * This method is used to send a GET request to the specified endpoint with
	 * optional query parameters.
	 * 
	 * @param endpoint    The endpoint URL to which the GET request will be sent.
	 * @param queryParams A map of query parameters to be included in the request.
	 * @author Suresh kode
	 */

	public Response getRequest(String endpoint, Map<String, String> queryParams) {

		try {
			// Create a new RequestSpecification object using RestAssured.
			RequestSpecification request = RestAssured.given();
			// If query parameters are provided, add them to the request.
			if (queryParams != null) {
				request.queryParams(queryParams);
			}
			// Process the response and return the response here
			return request.get(endpoint);

		} catch (Exception e) {
			// Print the stack trace if an exception occurs during the request execution.
			e.printStackTrace();
		}
		System.out.println("Some exception has occurred during the HTTP Client creation." + "Returning false");
		return null;

	}

	/**
	 * Sends a POST request to the specified endpoint with the given request body.
	 * This method is used when there are no query parameters to be sent along with
	 * the request.
	 *
	 * @param endpoint    The URL of the API endpoint where the PUT request will be
	 *                    sent.
	 * @param requestBody The JSON body that will be sent with the PUT request.
	 *                    Author: [Suresh Kode]
	 */
	// POST request
	public Response postRequest(String endpoint, String requestBody) {

		// Create a new RequestSpecification object and set the content type to JSON.
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		// Send a POST request to the specified endpoint with the JSON body.
		request.body(requestBody);

		return request.post(endpoint);
	}

	/**
	 * Sends a POST request to the specified endpoint with the given request body
	 * and query parameters. This method allows adding query parameters to the
	 * request.
	 *
	 * @param endpoint    The URL of the API endpoint where the PUT request will be
	 *                    sent.
	 * @param requestBody The JSON body that will be sent with the PUT request.
	 * @param queryParams A map containing query parameters to be included in the
	 *                    PUT request. Author: [Suresh Kode]
	 */

	public Response postRequest(String endpoint, String requestBody, Map<String, String> queryParams) {

		// Create a new RequestSpecification object and set the content type to JSON.
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		// passing the query parameters
		request.queryParams(queryParams);

		// Send a POST request to the specified endpoint with the JSON body.
		request.body(requestBody);
		return request.post(endpoint);
	}

	// PUT request
	/**
	 * Sends a PUT request to the specified endpoint with the given request body.
	 * This method is used when there are no query parameters to be sent along with
	 * the request.
	 *
	 * @param endpoint    The URL of the API endpoint where the PUT request will be
	 *                    sent.
	 * @param requestBody The JSON body that will be sent with the PUT request.
	 *                    Author: [Suresh Kode]
	 */

	public Response putRequest(String endpoint, String requestBody) {

		// Create a new RequestSpecification object and set the content type to JSON.
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");

		// Send a PUT request to the specified endpoint with the JSON body.
		request.body(requestBody);
		return request.put(endpoint);
	}

	// PUT request
	/**
	 * Sends a PUT request to the specified endpoint with the given request body and
	 * query parameters. This method allows adding query parameters to the request.
	 *
	 * @param endpoint    The URL of the API endpoint where the PUT request will be
	 *                    sent.
	 * @param requestBody The JSON body that will be sent with the PUT request.
	 * @param queryParams A map containing query parameters to be included in the
	 *                    PUT request. Author: [Suresh Kode]
	 */

	public Response putRequest(String endpoint, String requestBody, Map<String, String> queryParams) {

		// Create a new RequestSpecification object and set the content type to JSON.
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		// passing the query parameters
		request.queryParams(queryParams);

		// Send a PUT request to the specified endpoint with the JSON body.
		request.body(requestBody);
		return request.put(endpoint);
	}

	/**
	 * This method is used to send a DELETE request to the specified endpoint.
	 * 
	 * @param endpoint The endpoint URL to which the DELETE request will be sent.
	 * @author Suresh kode
	 */
	// DELETE request
	public Response deleteRequest(String endpoint) {
		return RestAssured.delete(endpoint);
	}

	/**
	 * This method is used to send a DELETE request to the specified endpoint with
	 * optional query parameters.
	 * 
	 * @param endpoint    The endpoint URL to which the DELETE request will be sent.
	 * @param queryParams A map of query parameters to be included in the request.
	 * @author Suresh kode
	 */
	public Response deleteRequest(String endpoint, Map<String, String> queryParams) {

		try {
			// Create a new RequestSpecification object using RestAssured.
			RequestSpecification request = RestAssured.given();

			// If query parameters are provided, add them to the request.
			if (queryParams != null) {
				request.queryParams(queryParams);
			}
			// Process the response and return the response here
			return request.delete(endpoint);

		} catch (Exception e) {
			// Print the stack trace if an exception occurs during the request execution.
			e.printStackTrace();
		}
		System.out.println("Some exception has occurred during the HTTP Client creation." + "Returning false");
		return null;

	}

	/**
	 * The Method ResponseSchemavalidation which is used for validating the response schema .
	 *  This method likely compares the actual response from an API
	 * endpoint against a predefined JSON schema to ensure it matches the expected
	 * structure and data types
	 * @param endpoint    The endpoint URL to which request will be sent for response validation.
	 * @param jsonSchema expected JSON schema for comparison.
	 * @author Suresh kode
	 */

	public void APIResponseSchemavalidation(String endpoint, String jsonSchema) {

		// Make API call and get the response
		Response response = RestAssured.get(endpoint);

		// Validate the response against the dynamic JSON schema
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
	}
		
	

}

package RelatedApi;

import java.io.IOException;

import org.testng.Assert;

import com.driver.Driver;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API1 extends Driver{
	
		public void test_GetParameters_TPL_SI_1() throws IOException {

			// URI Initialization(Provide the URI for the api here)
			RestAssured.baseURI = readProp.getConfig("listBaseUri");

			// Header specifications(Mention all api-keys,authorization parameters
			// here)
			RequestSpecification httpRequest = RestAssured.given();

			httpRequest.header("Content-Type", "application/json");

			httpRequest.header("apikey", readProp.getConfig("apiSecretKey"));

			String posId = jsonUtil.readDataFromTheJson("PosId", "Input");

			httpRequest.header("x-posId", posId);

			// Response Body
			Response response = httpRequest.request(Method.GET,"/parameters/TPL_SI_1");

			String responseBody = response.getBody().asString();
			System.out.println("(==GetParameters==)");

			System.out.println("Response_Ack : " + responseBody);

			// ********TEST SCENARIOS ARE TO BE PUT HERE***********

			// Checks on Response Code
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200, "Expected Status Code : ");
			// Check on Internal Server Error
			Assert.assertNotEquals(responseBody, "Internal Server Error");
			// Check Response Body is not blank
			Assert.assertNotEquals(responseBody, " ");
			// Check Connection Time-out
			Assert.assertNotEquals(responseBody, "Connection timed out: connect");

		}

		public void test_GetParameters_PAPERLESS_APP_1() throws IOException {

			// URI Initialization(Provide the URI for the api here)
			RestAssured.baseURI = readProp.getConfig("listBaseUri");

			// Header specifications(Mention all api-keys,authorization parameters
			// here)
			RequestSpecification httpRequest = RestAssured.given();

			httpRequest.header("Content-Type", "application/json");

			httpRequest.header("apikey", readProp.getConfig("apiSecretKey"));

			// Response Body
			Response response = httpRequest.request(Method.GET,
					"/parameters/PAPERLESS_APP_1");

			String responseBody = response.getBody().asString();

	  		System.out.println("Response Body is =>  " + responseBody);

			// ********TEST SCENARIOS ARE TO BE PUT HERE***********

			// Checks on Response Code
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200, "Expected Status Code : ");
			// Check on Internal Server Error
			Assert.assertNotEquals(responseBody, "Internal Server Error");
			// Check Response Body is not blank
			Assert.assertNotEquals(responseBody, " ");
			// Check Connection Time-out
			Assert.assertNotEquals(responseBody, "Connection timed out: connect");

			boolean is_present = responseBody.contains("maxFingerSignatures");
			System.out.println(response.jsonPath().get("data/maxFingerSignatures"));

			System.out.println("maxFingerSignatures is present : " + is_present);

		}
	}



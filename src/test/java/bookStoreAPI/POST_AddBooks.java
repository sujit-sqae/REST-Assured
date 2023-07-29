package bookStoreAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class POST_AddBooks {
	private String baseURI = "https://demoqa.com/BookStore/v1/Books";

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = baseURI;
    }

    @Test
    public void testCreateBook() {
        String requestBody = "{ \"userId\": \"String@1\", \"collectionOfIsbns\": [ { \"isbn\": \"string\" } ] }";

        Response response = given()
        		.accept("application/json")
                .contentType("application/json")
                .body(requestBody)
                .post();

        // Verify the response status code
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 401, "Expected status code: 401");

        // Verify the response body contains details of the newly created book
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("code"), "Response body should contain code");
        assertTrue(responseBody.contains("message"), "Response body should contain message");
        //assertTrue(responseBody.contains("1234567890"), "Response body should contain ISBN");
        // Add more assertions as needed based on the expected response body structure
    }

}

package bookStoreAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Get_BookStoreBookList {
	private String baseURI = "https://demoqa.com/BookStore/v1/Books";
	
	@BeforeClass
    public void setUp() {
        RestAssured.baseURI = baseURI;
    }

    @Test
    public void testGetBooks() {
        Response response = given().get();

        // Verify the response status code
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "Expected status code: 200");

        // Verify the response body contains specific book details
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("isbn"), "Response body should contain isbn");
        assertTrue(responseBody.contains("title"), "Response body should contain title");
        assertTrue(responseBody.contains("author"), "Response body should contain author");
        // Add more assertions as needed based on the expected response body structure
    }
}

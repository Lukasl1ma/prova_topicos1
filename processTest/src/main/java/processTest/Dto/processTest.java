package processTest.Dto;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class processTest {
	
	private static final String PROCESS_URL = "http://localhost:8082/customers/";
	private static final String BASE_URL = "http://localhost:8082/";
	
	@Before
	public void setUp() {
		RestAssured.baseURI = BASE_URL;
	}
	
	@Test
	public void testCreateProcess_withSuccess() {
		String code = "1";
		Response response = createProcessWithId(code);
		response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
	}

	@Test
	public void testCreateProcess_withExistingCode() {
		String code = "1";
		Response response = RestAssured.get(PROCESS_URL + code);

		if (response.getStatusCode() == HttpStatus.SC_OK) {
			RestAssured.given()
				.contentType(ContentType.JSON)
				.post(PROCESS_URL)
				.then()
				.assertThat()
				.statusCode(HttpStatus.SC_BAD_REQUEST);
		} else {
			Response write = createProcessWithId(code);
			write.then().assertThat().statusCode(HttpStatus.SC_CREATED);
		}
	}

	@Test
	public void testGetProcessById_withSuccess() {
		String code = "1";
		createProcessWithId(code);
		Response response = RestAssured.get(PROCESS_URL + code);
		response.then().assertThat().statusCode(HttpStatus.SC_OK);
	}

	@Test
	public void testGetProcessById_withFail() {
		String nonExistingProcessId = "1";
		Response response = RestAssured.get(BASE_URL + nonExistingProcessId);
		response.then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
	}


	private Response createProcessWithId(String idNumber) {
		ProcessDTO newCustomer = new ProcessDTO(idNumber, "lucas", "lucas@email.com", 30, "teste");

		Response response = RestAssured.given()
			.body(newCustomer)
			.contentType(ContentType.JSON)
			.post(PROCESS_URL);
		return response;
	}

}

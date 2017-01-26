
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;




public class SanityPublisher extends FunctionalTest {
	
	String Response;
	String AccessToken;;


	
	@Test(enabled = true, testName = "", description = "",
			groups = { "Sanity Publisher" })

	public void getAccessToken() throws ParserConfigurationException, SAXException,
			IOException, InterruptedException {
		
		//RestAssured.baseURI = "https://sgwin2012r2.skygiraffe.com";
		//RestAssured.basePath = "/skygiraffeauthorizationserver/oauth2/";
		//String Response = 
		//`RestAssured.given().body("grant_type=password&username=test1%401.com&password=123&client_id=099153c2625149bc8ecb3e85e03f0022&client_secret=IxrAjDoa2FqElO7IhrSrUJELhUckePEPVpaePlS_Xaw").when().get("/token").then().statusCode(200).toString();
		
		String client_id = "099153c2625149bc8ecb3e85e03f0022";
		String client_secret = "IxrAjDoa2FqElO7IhrSrUJELhUckePEPVpaePlS_Xaw";
		String user = "publisher1%401.com";
		String password = "123";
		
		RestAssured.given().body("grant_type=password&username="  + user + "&password=" + password + "&client_id="
				+ client_id + "&client_secret=" + client_secret).when().get("/token").then().statusCode(200);
		
		 Response = RestAssured.given().body("grant_type=password&username="  + user + "&password=" + password + "&client_id="
				+ client_id + "&client_secret=" + client_secret).when().get("/token").asString();
		

	    JsonPath jsonPath = new JsonPath(Response);
	    AccessToken = jsonPath.getString("access_token");
/*
	    String response =
	    		RestAssured.given()
	                .parameters("username", "test1@1.com", "password", "123", 
	                           "grant_type", "password", "scope", "read write", 
	                           "client_id", client_id, "client_secret", client_secret)
	                .auth()
	                .preemptive()
	                .basic("clientapp","123456")
	            .when()
	                .post("/oauth/token")
	                .asString();

	    JsonPath jsonPath = new JsonPath(response);
	    accessToken = jsonPath.getString("access_token");
	}
		
		*/
		
		//s.given().when().get("http://google.comss").then().

		//Thread.sleep(1000);
		// go to URL Constant

		
	}
	
	@Test(enabled = true, testName = "getApplications", description = "getApplications", groups = { "Sanity Publisher" })

	public void getApplications() throws ParserConfigurationException, SAXException, IOException, InterruptedException {

		RestAssured.basePath = "/publisher/api/v2/";

		String body = "{\"OS\" : \"IOS\",\"Device\" : \"iphone\"}";
		RestAssured.given().auth().oauth2(AccessToken).contentType("application/json").body(body).when()
				.post("/Application").then().body(containsString("ApplicationName")).statusCode(200);

	}
	
	
	@Test(enabled = false, testName = "getApplications", description = "getApplications", groups = { "Sanity Publisher" })

	public void get() throws ParserConfigurationException, SAXException, IOException, InterruptedException {

		RestAssured.basePath = "/publisher/api/v3/";

		String body = "{\"OS\" : \"IOS\",\"Device\" : \"iphone\"}";
		RestAssured.given().auth().oauth2(AccessToken).contentType("application/json").body(body).when()
				.post("/Application").then().body(containsString("ApplicationName")).statusCode(200);

	}
	


	
	

}

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;

import org.hamcrest.Matchers.*;




public class SanityPublisher extends FunctionalTest {
	
	@Test(enabled = true, testName = "", description = "",
			groups = { "Sanity Publisher" })

	public void getAccessToken() throws ParserConfigurationException, SAXException,
			IOException, InterruptedException {
		
		//RestAssured.baseURI = "https://sgwin2012r2.skygiraffe.com";
		//RestAssured.basePath = "/skygiraffeauthorizationserver/oauth2/";
		//String Response = 
		//`RestAssured.given().body("grant_type=password&username=test1%401.com&password=123&client_id=099153c2625149bc8ecb3e85e03f0022&client_secret=IxrAjDoa2FqElO7IhrSrUJELhUckePEPVpaePlS_Xaw").when().get("/token").then().statusCode(200).toString();
		String Response = RestAssured.given().body("grant_type=password&username=test1%401.com&password=123&client_id=099153c2625149bc8ecb3e85e03f0022&client_secret=IxrAjDoa2FqElO7IhrSrUJELhUckePEPVpaePlS_Xaw").when().get("/token").asString();

		String client_id = "099153c2625149bc8ecb3e85e03f0022";
		String client_secret = "IxrAjDoa2FqElO7IhrSrUJELhUckePEPVpaePlS_Xaw";

	    JsonPath jsonPath = new JsonPath(Response);
	   String  accessToken = jsonPath.getString("access_token");
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

}

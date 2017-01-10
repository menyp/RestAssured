import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;


public class FunctionalTest {

	  @BeforeClass
	    public static void setup() {
	        String port = System.getProperty("server.port");
	        if (port == null) {
	            RestAssured.port = Integer.valueOf(8080);
	        }
	        else{
	            RestAssured.port = Integer.valueOf(port);
	        }
	        
	    //RestAssured.baseURI = "https://sgwin2012r2.skygiraffe.com";
    	//RestAssured.basePath = "/skygiraffeauthorizationserver/oauth2/";


	        String basePathAuth = System.getProperty("server.base");
	        if(basePathAuth==null){
	        	basePathAuth = "/skygiraffeauthorizationserver/oauth2/";
	        	
	        }
	        RestAssured.basePath = basePathAuth;

	        String baseHost = System.getProperty("server.host");
	        if(baseHost==null){
	            baseHost = "https://sgwin2012r2.skygiraffe.com";
	        }
	        RestAssured.baseURI = baseHost;

	    }
}

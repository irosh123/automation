package restassured.api.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class RestUtils {

public Response createUserPOST(String url, String body){

    return RestAssured.given().headers("Content-Type","application/json","domain","WAPP","product","TRAVEL","business-flow","APP","api","USER_CREATE","operation-flow","CREATE_FLOW")
            .log().all()
            .body(body)
            .post(url);


}

}

package restassured.api.utils;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

public Response createUserPOST(String url, String body){

    return RestAssured.given().headers("Content-Type","application/json","domain","WAPP","product","TRAVEL","business-flow","APP","api","USER_CREATE","operation-flow","CREATE_FLOW")
            .log().all()
            .body(body)
            .post(url);


}
    public Response sendVerificationPOST(String url, String body) {

        return RestAssured.given().headers("Content-Type", "application/json", "domain", "WAPP", "product", "TRAVEL", "business-flow", "APP", "api", "SEND_VERIFICATION_EMAIL", "operation-flow", "CREATE_FLOW")

                .log().all()
                .body(body)
                .post(url);

    }

    public Response verifyEmailGet(String url) {
        return RestAssured.given().headers("Content-Type", "application/json", "domain", "WAPP", "product", "TRAVEL", "business-flow", "APP", "api", "VERIFY_EMAIL", "operation-flow", "CREATE_FLOW")
                .log().all()
                .get(url);

    }


}

package helper;

import io.restassured.response.Response;
import org.python.antlr.ast.Str;
import restassured.api.pojo.sendverificationemail.SendVerification;
import restassured.api.pojo.usercreate.UserCreate;
import restassured.api.utils.RestUtils;
import restassured.api.utils.URLGenerator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ResponseHelper {

    String baseUrl;
    RestUtils utils;
    URLGenerator url;
    UserCreate userCreatePojo;
    SendVerification sendVerification;

    public ResponseHelper(String baseUrl) throws IOException {
        this.baseUrl = baseUrl;
        utils = new RestUtils();
        //url = new   URLGenerator(baseUrl);
        url = new URLGenerator();
        userCreatePojo = new UserCreate();
        sendVerification = new SendVerification();

    }




    public Response createUserDetails(Map<String,String> testData) throws Exception {


        Response response;
        String body = userCreatePojo.getUsers(testData);
        try{
            response = utils.createUserPOST(url.getUrl(this.baseUrl),body);


            if(response.getStatusCode()!=200){
                throw new Exception("Failed to Create User using API "+url.getUrl(this.baseUrl)+" and Response body is "+response.getBody().asString());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }





        return response;
    }

    public Response sendVerification(Map<String,String> testData) throws Exception {


        Response response;
        String body =sendVerification.getUsers(testData);
        try{
            response = utils.sendVerificationPOST(url.getUrl(this.baseUrl),body);
            if(response.getStatusCode()!=200){
                throw new Exception("Failed to Send verification mail using API "+url.getUrl(this.baseUrl)+" and Response body is "+response.getBody().asString());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return response;
}

    public Response VerifyEmail(Map<String,String> testData) throws Exception {


        Response response;
        String map = (testData.get("verifyLink"));
        String result = java.net.URLDecoder.decode(map, StandardCharsets.UTF_8.name());


        try{
            response = utils.verifyEmailGet(url.getUrl2(this.baseUrl)+result);


            if(response.getStatusCode()!=200){
                throw new Exception("Failed to Create User using API "+url.getUrl(this.baseUrl)+map+" and Response body is "+response.getBody().asString());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return response;
}


}


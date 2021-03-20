package helper;

import io.restassured.response.Response;
import restassured.api.pojo.UserCreate;
import restassured.api.utils.RestUtils;
import restassured.api.utils.URLGenerator;

import java.io.IOException;
import java.util.Map;

public class UserCreateHelper {

    String baseUrl;
    RestUtils utils;
    URLGenerator url;
    UserCreate userCreatePojo;

    public UserCreateHelper(String baseUrl) throws IOException {
        this.baseUrl = baseUrl;
        utils = new RestUtils();
        //url = new   URLGenerator(baseUrl);
        url = new URLGenerator();
        userCreatePojo = new UserCreate();
    }




    public Response createUserDetails(Map<String,String> testData) throws Exception {


        Response response;
        String body = userCreatePojo.getUsers(testData);
        try{
            response = utils.createUserPOST(url.getBaseUrl(this.baseUrl),body);
            if(response.getStatusCode()!=200){
                throw new Exception("Failed to Create User using API "+url.getBaseUrl(this.baseUrl)+" and Response body is "+response.getBody().asString());
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }



        return response;
    }
}

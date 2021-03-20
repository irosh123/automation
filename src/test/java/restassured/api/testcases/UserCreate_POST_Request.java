package restassured.api.testcases;

import helper.GenericHelper;
import helper.UserCreateHelper;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.io.IOException;
import java.util.Map;
import java.util.Properties;


public class UserCreate_POST_Request {

    @Test
    public void createUser() throws Exception {
        Response response;
        GenericHelper helper = new GenericHelper();
        Properties property = helper.loadProperty("qa");
        String baseUrl = property.getProperty("baseUrl");

        UserCreateHelper user = new UserCreateHelper(baseUrl);

        Map<String,String> testData;
        testData= helper.readJsonFile("createUser","userCreateTest.json","Registration");
        response = user.createUserDetails(testData);
        response.prettyPrint();



      /*  Map<String,String> map;
        map = helper.readJsonFile("createUser","userCreateTest.json","Registration");
         System.out.println(map.get("email"));

        Properties prop = helper.loadProperty("qa");
        System.out.println(prop.get("baseUrl"));

       */



    }
}

package restassured.api.testcases;

import helper.GenericHelper;
import helper.UserCreateHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.is;

import org.testng.annotations.Test;


import static org.hamcrest.MatcherAssert.assertThat;


import java.util.*;



public class UserCreate_POST_Request {

    public static String jsonAsString;

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


        String firstName = JsonPath.from(response.getBody().asString()).get("result.person.firstName").toString();
        assertThat((new Object[]{testData.get("firstName")}), is  (new Object[]{firstName}));





    }



}

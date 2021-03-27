package restassured.api.testcases;

import helper.GenericHelper;
import helper.ResponseHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.is;


import org.testng.annotations.Test;


import static org.hamcrest.MatcherAssert.assertThat;


import java.util.*;



public class TestPack {






    @Test
    public void createUser() throws Exception {
        Response response;
        GenericHelper helper =new GenericHelper();
        Properties property = helper.loadProperty("qa");
        String baseUrl = property.getProperty("baseUrl");
        ResponseHelper user=new ResponseHelper(baseUrl);

        Map<String,String> testData;
        testData= helper.readJsonFile("createUser","userCreateTest.json","Registration");

        response = user.createUserDetails(testData);

        response.prettyPrint();


        String firstName = JsonPath.from(response.getBody().asString()).get("result.person.firstName").toString();
        String personReference = JsonPath.from(response.getBody().asString()).get("result.person.personReference").toString();

        helper.writeToJsonFile(personReference,baseUrl);

        assertThat((new Object[]{testData.get("firstName")}), is  (new Object[]{firstName}));





    }


    @Test
    public void sendVerification() throws Exception {
        Response response;
        GenericHelper helper=new GenericHelper();
        Properties property = helper.loadProperty("qa");
        String baseUrl = property.getProperty("baseUrl");
        ResponseHelper user=new ResponseHelper(baseUrl);

        Map<String, String> testData;
        testData = helper.readJsonFile("preData", "verificationEmailTest.json", "Registration");

        response = user.sendVerification(testData);

        response.prettyPrint();
        String verifyLink1 = JsonPath.from(response.getBody().asString()).get("result").toString();
        String verifyLink = verifyLink1.substring(verifyLink1.indexOf("?") + 1);
        helper.writeUrl(verifyLink);
    }

    @Test
    public void verifyEmail() throws Exception {
        Response response;
        GenericHelper helper = new GenericHelper();
        Properties property = helper.loadProperty("qa");
        String baseUrl = property.getProperty("baseUrl");
        ResponseHelper user = new ResponseHelper(baseUrl);

        Map<String, String> testData;
        testData = helper.readJsonFile("VerifyEmailLink", "verifyUrl.json", "Registration");

        response = user.VerifyEmail(testData);

        response.prettyPrint();

    }
}

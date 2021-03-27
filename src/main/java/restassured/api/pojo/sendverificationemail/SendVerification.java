package restassured.api.pojo.sendverificationemail;

import com.google.gson.Gson;
import helper.GenerateRandomNumber;
import helper.GenericHelper;
import restassured.api.utils.URLGenerator;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class SendVerification<baseUrl> {

    private String personReference ;



    GenerateRandomNumber generateRand;
    URLGenerator url;
    String baseUrl;

    public SendVerification () throws IOException {

        GenericHelper helper = new GenericHelper();
        url = new URLGenerator();
        Properties property = helper.loadProperty("qa");
        baseUrl = property.getProperty("baseUrl");
        generateRand = new GenerateRandomNumber();
    }
    public String getPersonReference() {
        return personReference;
    }

    public void setPersonReference(String personReference) {
        this.personReference = personReference;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUsers(Map<String,String> testData) throws IOException {



        SendVerification sendVerification =new SendVerification();
        sendVerification.setPersonReference(testData.get("personReference"));
        sendVerification.setBaseUrl(baseUrl);
        Gson gson = new Gson();
        return gson.toJson(sendVerification);



    }

}

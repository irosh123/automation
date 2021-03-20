package restassured.api.utils;

public class URLGenerator {
    public String userCreateResource="/master";

//    public URLGenerator(String baseURL) {
//    userCreateResource = baseURL + userCreateResource;
//    }

    public String getBaseUrl(String baseURL){
       return baseURL + userCreateResource;

    }
}

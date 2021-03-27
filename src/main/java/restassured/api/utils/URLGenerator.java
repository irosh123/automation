package restassured.api.utils;

import org.json.simple.JSONObject;

public class URLGenerator {


    public String userCreateResource = "/master";
    public String userCreateResource1 = "/master?";
 //   private String verifyLink;



//    }
//    public  void setUrl (String newUrl){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.get("verifyUrl").toString().replace("/[?#].*/", "");
//        String verifyLink = jsonObject.toJSONString();
//        verifyLink = newUrl;

  //  }

    public String getUrl(String baseURL ) {
        return baseURL + userCreateResource;
    }

    public String getUrl2(String baseURL ) {
        return baseURL + userCreateResource1;
    }

    }



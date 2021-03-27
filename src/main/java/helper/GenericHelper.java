package helper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.python.antlr.ast.Str;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class GenericHelper {

    public Map<String,String>   readJsonFile(String methodName, String jsonFileName,String resourceFolderName) throws FileNotFoundException {

        String jsonFilePath  = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+resourceFolderName+ File.separator+jsonFileName;
        JsonElement jsonElement = (new JsonParser()).parse(new FileReader(jsonFilePath));
        JsonObject object = jsonElement.getAsJsonObject();
        JsonElement ele = object.get(methodName);
        JsonObject jObject = ele.getAsJsonObject();
        Map<String,String> mObject = new HashMap<String,String>();

        Iterator<?> iterator =jObject.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            mObject.put(entry.getKey().toString(), entry.getValue().toString().replace("\"",""));


        }

        return mObject;
    }



    public  Properties loadProperty (String fileName) throws IOException {

        String propertyPath = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+fileName+".properties";

        File file = new File(propertyPath);
        FileInputStream fileInput = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fileInput);
        return prop;



    }

    public void writeToJsonFile(String personReference, String baseUrl ) {

        //Creating a JSONObject object
        JsonObject jsonObject1 = new JsonObject();
        JSONObject jsonObject = new JSONObject();

        //JsonObject jsonObject1 = new JsonObject();


        String jsonFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Registration" + File.separator + "verificationEmailTest.json";
        //Inserting key-value pairs into the json object

        //jsonObject.put("preData",new JSONObject().put("personReference",personReference));

        jsonObject.put("personReference", personReference);
        jsonObject.put("baseUrl", baseUrl);


        try {
            FileWriter file = new FileWriter(jsonFilePath);
            //file.write(ja.toJSONString().replace("[]","{:}"));
            file.write("{");
            file.write("\"preData\"");
            file.write(":");
            file.write(jsonObject.toJSONString());
            file.write("}");
            file.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        System.out.println("JSON file created: " + jsonObject);
    }
        public void writeUrl(String verifyLink){

            //Creating a JSONObject object

            JSONObject jsonObject = new JSONObject();

            //JsonObject jsonObject1 = new JsonObject();
            String jsonFilePath  = System.getProperty("user.dir")+ File.separator+"src"+ File.separator+"main"+ File.separator+"resources"+ File.separator+"Registration"+ File.separator+"verifyUrl.json";
            //Inserting key-value pairs into the json object

            //jsonObject.put("preData",new JSONObject().put("personReference",personReference));


            jsonObject.put("verifyLink", verifyLink);


            try {
                FileWriter file = new FileWriter(jsonFilePath);
                //file.write(ja.toJSONString().replace("[]","{:}"));
                file.write("{");
                file.write("\"VerifyEmailLink\"");
                file.write(":");
                file.write(jsonObject.toJSONString());
                file.write("}");
                file.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
            System.out.println("JSON file created: "+jsonObject);
        }

    }



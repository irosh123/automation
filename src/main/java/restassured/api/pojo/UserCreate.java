package restassured.api.pojo;

import com.google.gson.Gson;
import helper.GenerateRandomNumber;
import helper.GenericHelper;
import restassured.api.utils.URLGenerator;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class UserCreate<baseUrl> {

    private String email;
    private String lastName;
    private String firstName;
    private String deviceCode;
    private String appVersion;
    private String phone;
    private String countryCode;
    private String loginPassword;
    private String dob;
    Integer randomNumber;
    private UserCreate_Audit audit;

    GenerateRandomNumber generateRand;
    URLGenerator url;
    String baseUrl;

    public UserCreate() throws IOException {

        GenericHelper helper = new GenericHelper();
        url = new URLGenerator();
        Properties property = helper.loadProperty("qa");
        baseUrl = property.getProperty("baseUrl");
        generateRand = new GenerateRandomNumber();
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public UserCreate_Audit getAudit() {
        return audit;
    }

    public void setAudit(UserCreate_Audit audit) {
        this.audit = audit;
    }







    public String getUsers(Map<String,String> testData) throws IOException {

        UserCreate_Audit auditPojo = new UserCreate_Audit();

        auditPojo.setLocalTime(testData.get("localTime"));
        auditPojo.setGMTTime(testData.get("GMTTime"));
        auditPojo.setAppRequestedTime(testData.get("appRequestedTime"));
        auditPojo.setAgentId(Integer.parseInt(testData.get("agentId")));
        auditPojo.setAgentName(testData.get("agentName"));
        auditPojo.setChannel(testData.get("channel"));


        UserCreate userCreatePojo = new UserCreate();

        userCreatePojo.setEmail(testData.get("email")+generateRand.randomNumberGenerate()+"@intervest.lk");
        userCreatePojo.setLastName(testData.get("lastName"));
        userCreatePojo.setFirstName(testData.get("firstName"));
        userCreatePojo.setDeviceCode(testData.get("deviceCode"));
        userCreatePojo.setAppVersion(testData.get("appVersion"));
        userCreatePojo.setPhone(testData.get("phone"));
        userCreatePojo.setCountryCode(testData.get("countryCode"));
        userCreatePojo.setLoginPassword(testData.get("loginPassword"));
        userCreatePojo.setDob(testData.get("dob"));
        userCreatePojo.setBaseUrl(baseUrl);
        userCreatePojo.setAudit(auditPojo);


        Gson gson = new Gson();
        return gson.toJson(userCreatePojo);

    }
}

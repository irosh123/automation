package restassured.api.pojo.usercreate;

import helper.GenerateRandomNumber;
import helper.GenericHelper;
import restassured.api.utils.URLGenerator;

import java.io.IOException;
import java.util.Properties;

public class UserCreate_Audit {

    private String localTime;
    private String GMTTime;
    private String appRequestedTime;
    private Integer agentId;
    private String agentName;
    private String channel;



    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getGMTTime() {
        return GMTTime;
    }

    public void setGMTTime(String GMTTime) {
        this.GMTTime = GMTTime;
    }

    public String getAppRequestedTime() {
        return appRequestedTime;
    }

    public void setAppRequestedTime(String appRequestedTime) {
        this.appRequestedTime = appRequestedTime;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }



}

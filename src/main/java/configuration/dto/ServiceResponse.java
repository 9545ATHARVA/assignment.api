package configuration.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Map;

//@Data
//@Builder
public class ServiceResponse {
    private String body;
    private int responceCode;
    private Map<String, String> responseHeader;

    public void setBody(String body) {
        this.body = body;
    }

    public void setResponceCode(int responceCode) {
        this.responceCode = responceCode;
    }

    public void setResponseHeader(Map<String, String> responseHeader) {
        this.responseHeader = responseHeader;
    }

    public String getBody() {
        return body;
    }

    public int getResponceCode() {
        return responceCode;
    }

    public Map<String, String> getResponseHeader() {
        return responseHeader;
    }

//    public ServiceResponse(String body, int responceCode, Map<String, String> responseHeader) {
//        this.body = body;
//        this.responceCode = responceCode;
//        this.responseHeader = responseHeader;
//    }

    public ServiceResponse() {
    }
}

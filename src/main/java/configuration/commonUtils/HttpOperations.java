package configuration.commonUtils;

import configuration.dto.ServiceResponse;

import java.util.Map;

public interface HttpOperations {

    ServiceResponse executeGetRequest(String uri, Map<String, String> additionalRequestHeader, String cityName);

}

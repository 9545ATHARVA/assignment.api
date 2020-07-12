package weatherApi;

import com.google.gson.Gson;
import configuration.commonUtils.HttpOperations;
import configuration.commonUtils.impl.HttpOperationsRestClientImpl;
import configuration.dto.ServiceResponse;
import configuration.dto.reponse.WeatherServiceResponse;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.hc.core5.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import commonUtils.ReadWriteFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static commonUtils.ReadWriteFile.getTempValueFromConfigFile;
import static configuration.commonUtils.URIManagement.weatherURI;
import static org.junit.Assert.assertEquals;
import static commonUtils.ReadWriteFile.insertUpdatedTempValueIntoConfigFile;


public class GetWeatherDetail {
    private static Logger log = LoggerFactory.getLogger(GetWeatherDetail.class);

    public String KEY_CITY_NAME = "cityName.value";
    public String KEY_API_TEMP = "webService.tempValue";

    public String cityName = getTempValueFromConfigFile(KEY_CITY_NAME);
    HttpOperations httpOperations = new HttpOperationsRestClientImpl();
    Gson gson = new Gson();


    public GetWeatherDetail() throws IOException {
    }

    /* Description : Postive | GET | Retrieve City Weather Details
     *
     * */

    @Test
    public void testWeatherSuccessfulResponseForACityName() throws IOException, ConfigurationException {
        log.info("-------Test Start For testGetBatchIdDetailsForSingleIdForSuccessResponse----");
        String uri = String.format(weatherURI);
        ServiceResponse serviceResponse = httpOperations.executeGetRequest(uri, new HashMap<String, String>(), cityName);

        Map<String, String> actualHeaders = serviceResponse.getResponseHeader();
//       Assert Response Header
        assertEquals(9, actualHeaders.size());

//       Assert Status Code
        assertEquals(HttpStatus.SC_OK, serviceResponse.getResponceCode());

        WeatherServiceResponse badgesServiceResponse = gson.fromJson(serviceResponse.getBody(), WeatherServiceResponse.class);
        String temp = String.valueOf(badgesServiceResponse.getMain().getTemp());
        System.out.println("Temperature value ::" + temp);

        insertUpdatedTempValueIntoConfigFile(KEY_API_TEMP, temp);

        log.info("-------Test END For testGetBatchIdDetailsForSingleIdForSuccessResponse----");
    }

}

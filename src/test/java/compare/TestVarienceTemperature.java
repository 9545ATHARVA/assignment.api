package compare;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import weatherApi.GetWeatherDetail;

import java.io.IOException;

import static commonUtils.ReadWriteFile.getTempValueFromConfigFile;

public class TestVarienceTemperature {

    private static Logger log = LoggerFactory.getLogger(GetWeatherDetail.class);
    public String KEY_WEBSITE_TEMP = "webSite.tempValue";
    public String KEY_API_TEMP = "webService.tempValue";

    public String VARIENCE_KEY = "varience.value";

    @Test
    public void testVarienceLogicForTemperatureFromSiteAndAPI() throws Exception {

        //get value from NDTV Website Weather section for Pune City
        String TempValueFromWebSite = getTempValueFromConfigFile(KEY_WEBSITE_TEMP);

        //get value from Webservice Weather for Pune City
        String TempValueFromWebService = getTempValueFromConfigFile(KEY_API_TEMP);

        checkVarinece(TempValueFromWebSite, TempValueFromWebService);

    }

    private void checkVarinece(String Site, String API) {
        try {
            //get value fof Variance for Config.properties file.
            double varience = Integer.parseInt(getTempValueFromConfigFile(VARIENCE_KEY));
            double diff = Double.parseDouble(Site) - Double.parseDouble(API);
            if (-varience < diff && diff < +varience) {
                log.info("Test For Varience Value Passed");
            } else {
                log.info("Test For Varience Value Failed  with diifernce is more than -> " + varience);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

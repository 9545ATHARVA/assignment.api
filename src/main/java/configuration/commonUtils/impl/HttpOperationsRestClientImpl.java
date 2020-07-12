package configuration.commonUtils.impl;

import configuration.commonUtils.HEADERS;
import configuration.commonUtils.HttpOperations;
import configuration.commonUtils.PARMETERS;
import configuration.dto.ServiceResponse;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static configuration.commonUtils.URIManagement.baseURI;
import static configuration.commonUtils.URIManagement.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpOperationsRestClientImpl implements HttpOperations {
    private static Logger log = LoggerFactory.getLogger(HttpOperationsRestClientImpl.class);

    /**
     * Method will be used to GET response using HTTP Call
     *
     * @param uri                     : URI to be hit
     * @param additionalRequestHeader : additional Header
     * @return Service Response
     */
    @Override
    public ServiceResponse executeGetRequest(String uri, Map<String, String> additionalRequestHeader, String cityName) {
        uri = baseURI.concat(context).concat(uri);

        log.info("Excecuting GET Request using URI " + uri + "and headers " + additionalRequestHeader);
        RestAssured.urlEncodingEnabled = false;
        Response response = RestAssured.given().contentType("application/json")
                .headers(additionalRequestHeader(additionalRequestHeader))
                .queryParam(PARMETERS.CityNameAttribute.getParmeter(), cityName)
                .queryParam(PARMETERS.UNITS.getParmeter(), PARMETERS.TempInCelsious.getParmeter())
                .queryParam(PARMETERS.API_ID.getParmeter(), "7fe67bf08c80ded756e598d6f8fedaea")
                .when().log().all().get(uri);
        return convertHttpResponseToServiceResponse(response);
    }

    private ServiceResponse convertHttpResponseToServiceResponse(Response response) {

        Map<String, String> headers = new HashMap<>();

        response.getHeaders().asList().forEach(responseHeader -> headers.put(responseHeader.getName(), responseHeader.getValue()));
        log.info("Response from the request . Response Headers " + headers + " response body as " + response.getBody());

        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setResponceCode(response.getStatusCode());
        serviceResponse.setResponseHeader(headers);
        serviceResponse.setBody(response.getBody().prettyPrint());
        return serviceResponse;
    }


    /**
     * Method will be used to add any additional header to the default Header List
     *
     * @param additionalRequestHeader : additional parameter to be added
     * @return Headers
     */
    private Headers additionalRequestHeader(Map<String, String> additionalRequestHeader) {
        List<Header> defaultRequestHeaders = new ArrayList<Header>();
        defaultRequestHeaders.add(new Header(HEADERS.CONTENTTYPE.getHeader(), "application/json"));

        if (additionalRequestHeader != null && additionalRequestHeader.size() > 0) {
            final List<Header> requestHeaders = new ArrayList<Header>();

            additionalRequestHeader.entrySet().
                    forEach(e -> requestHeaders.add(new Header(e.getKey(), e.getValue())));

            defaultRequestHeaders.addAll(requestHeaders);

        }

        return new Headers(defaultRequestHeaders);
    }
}

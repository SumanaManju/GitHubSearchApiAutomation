package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.client.*;
import com.qa.data.SearchLabelResource;
import com.qa.util.MyClass;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class SearchLabelTest extends TestBase {

    TestBase testBase;
    String url, serviceUrl, apiUrl;
    CloseableHttpResponse closeableHttpResponse;
    File file = new File("src/test/resources/json/searchLabel.json");

    @BeforeMethod
    public void setUp() {
        testBase = new TestBase();
        apiUrl = prop.getProperty("URL");
        serviceUrl = prop.getProperty("serviceURLSearchLabel");
        url = apiUrl + serviceUrl;
    }

    @Test
    public void getResponse() throws IOException {
        closeableHttpResponse = RestClient.get(url);
    }

    @Test
    public void validateResponseCode() {
        Assertions.assertEquals(closeableHttpResponse.getStatusLine().getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test
    public void validateResponseMessage() throws IOException, JSONException {
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
        MyClass<SearchLabelResource> myClass = new MyClass<SearchLabelResource>(SearchLabelResource.class);
        myClass.getApiResponse(String.valueOf(responseString), file);
    }

    @AfterMethod
    public void quite() throws IOException {
      //  closeableHttpResponse.re
    }
}

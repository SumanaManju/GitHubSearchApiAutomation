package com.qa.tests;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.SearchCodeResource;
import com.qa.data.UserRepositoryResource;
import com.qa.util.MyClass;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class SearchUserRepositoryTest extends TestBase {

    TestBase testBase;
    String url;
    CloseableHttpResponse closeableHttpResponse;
    File file = new File("src/test/resources/json/userRepository.json");


    @BeforeMethod
    public void setUp() {
        testBase = new TestBase();
        url = prop.getProperty("serviceURLSearchUserRepository");
    }

    @Test
    public void getResponse() throws IOException {
        closeableHttpResponse = RestClient.get(url);
    }

    @Test
    public void validateResponseCode()  {
        Assertions.assertEquals(closeableHttpResponse.getStatusLine().getStatusCode(), RESPONSE_STATUS_CODE_200);
    }

    @Test
        public void validateResponseMessage() throws IOException, JSONException {
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
        MyClass<UserRepositoryResource[]> myClass = new MyClass<UserRepositoryResource[]>(UserRepositoryResource[].class);
        myClass.getApiResponse(String.valueOf(responseString), file);
    }
}

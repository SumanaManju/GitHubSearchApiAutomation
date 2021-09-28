package com.qa.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;

public class RestClient {

    public static CloseableHttpResponse get(String url) throws IOException {

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            httpget.addHeader("Accept" , "application/vnd.github.mercy-preview+json");
            return httpClient.execute(httpget);
    }
}

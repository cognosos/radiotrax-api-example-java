package com.cognosos.radiotrax.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class App {

    // Example HTTP client code from
    // https://hc.apache.org/httpcomponents-client-ga/httpclient/examples/org/apache/http/examples/client/ClientPreemptiveBasicAuthentication.java

    public static void main(String[] args)  throws Exception  {
        HttpHost target = new HttpHost(ApiTestData.API_SERVER_HOST, 443, "https");

        // Setup Credentials provider to return Basic Auth when prompted by server
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials(ApiTestData.API_USERNAME, ApiTestData.API_PASSWORD)
        );

        try (CloseableHttpClient httpclient =
                HttpClients
                    .custom()
                    .setDefaultCredentialsProvider(credsProvider)
                    .build()
            ) {

            String nodeUpdatePath = "/node/updateNodes";
            String queryParams = "application_code=" + ApiTestData.API_APP_CODE;
            String postUrl = target.toURI() + nodeUpdatePath + "?" + queryParams;
            HttpPost httpPost = new HttpPost(postUrl);

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(ApiTestData.inventory);
            httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

            System.out.println("Executing request " + httpPost.getRequestLine() + " to target " + target);
            System.out.println("----------------------------------------");

            try (CloseableHttpResponse response = httpclient.execute(target, httpPost)) {
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
            }
        }
    }

}

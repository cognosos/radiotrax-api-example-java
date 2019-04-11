package com.cognosos.radiotrax.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;


public class App {

    public static void main(String[] args) throws Exception {
        var configuration = CognososApiConfiguration.GetConfiguration();
        var app = new App(configuration);
        app.run();
    }

    private CognososApiConfiguration config;
    private HttpHost target;
    private ObjectMapper mapper = new ObjectMapper();
    private CredentialsProvider credsProvider = new BasicCredentialsProvider();

    private App(CognososApiConfiguration apiconfig) {
        config = apiconfig;
        target = HttpHost.create(config.api_server_host);
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(config.api_username, config.api_password)
        );
    }

    private void run() throws Exception {
        try(var httpclient = HttpClients
                .custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build())
        {
            insertInventoryRecords(httpclient);
            attachTracker(httpclient, "4010001", InventoryData.inventory[0]);
            detachTracker(httpclient, "4010001");
        }
    }

    private void insertInventoryRecords(CloseableHttpClient httpclient) throws Exception {
        var uri = new URIBuilder(target.toURI())
                .setPath("/node/updateNodes")
                .setParameter("application_code", config.api_app_code)
                .setParameter("x-api-key", config.api_apikey)
                .build();

        var jsonBody = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(InventoryData.inventory);

        doRequest(httpclient, uri, jsonBody);

    }

    private void attachTracker(CloseableHttpClient httpclient, String deviceId, InventoryItem item) throws Exception {
        var uri = new URIBuilder(target.toURI())
                .setPath("/node/attach")
                .setParameter("application_code", config.api_app_code)
                .setParameter("x-api-key", config.api_apikey)
                .setParameter("device_id", deviceId)
                .setParameter("asset_identifier", item.getAsset_identifier())
                .build();

        doRequest(httpclient, uri, null);
    }

    private void detachTracker(CloseableHttpClient httpclient, String deviceId) throws Exception {
        var uri = new URIBuilder(target.toURI())
                .setPath("/node/detach")
                .setParameter("application_code", config.api_app_code)
                .setParameter("x-api-key", config.api_apikey)
                .setParameter("device_id", deviceId)
                .build();

        doRequest(httpclient, uri, null);
    }

    private void doRequest(CloseableHttpClient httpclient, URI uri, String body) throws IOException {
        HttpPost req = new HttpPost(uri);
        if(body != null) {
            req.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));
            System.out.println("Request data is:");
            System.out.println(body);
            System.out.println("----------------------------------------");
        }
        System.out.println("Executing request " + req.getRequestLine() + " to target " + target);
        System.out.println("----------------------------------------");
        try (var response = httpclient.execute(target, req)) {
            System.out.println(response.getStatusLine());
            System.out.println(EntityUtils.toString(response.getEntity()));
        }
        System.out.println("----------------------------------------");
    }
}


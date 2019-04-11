package com.cognosos.radiotrax.apiclient;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;

@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class CognososApiConfiguration {
    public String api_server_host;
    public String api_app_code;
    public String api_username;
    public String api_password;
    public String api_apikey;

    public static String DEFAULT_CONFIG_FILE = "api_config.json";

    public static CognososApiConfiguration GetConfiguration() throws Exception {
        return GetConfiguration(DEFAULT_CONFIG_FILE);
    }

    public static CognososApiConfiguration GetConfiguration(String filename) throws Exception {
        var jsonData = Files.readAllBytes(Paths.get(filename));
        var objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonData, CognososApiConfiguration.class);
    }

}



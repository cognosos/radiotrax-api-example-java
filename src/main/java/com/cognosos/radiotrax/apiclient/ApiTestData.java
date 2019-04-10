package com.cognosos.radiotrax.apiclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiTestData {
    public static String API_SERVER_URL = "https://api.cognosos.net/";

    public static String API_APP_CODE = "YOUR_APP_CODE";
    public static String API_USERNAME = "YOUR_APP_USERNAME";
    public static String API_PASSWORD = "YOUR_APP_PASSWORD";

    public static InventoryItem[] inventory = {
            new InventoryItem("A1001", "1FTFW1RG0HFA66295", "Ford", "F-150", "Raptor (3.5 V6) CREW CAB PICKUP 4-DR"),
            new InventoryItem("A1002", "1FTFW1CT8EFB42220", "Ford", "F-150", "SuperCrew (3.5L V6 TURBO), CREW CAB PICKUP 4-DR")
    };

    public static Map<String, Object> getInventoryMap() {
        Map<String, Object> inventoryMap = new HashMap<>();
        inventoryMap.put("asset_identifier", "A1001");
        inventoryMap.put("VIN", "1FTFW1RG0HFA66295");
        inventoryMap.put("Make", "Ford");
        inventoryMap.put("Model", "150");
        inventoryMap.put("Style", "Raptor (3.5 V6) CREW CAB PICKUP 4-DR");
        return inventoryMap;
    }

}
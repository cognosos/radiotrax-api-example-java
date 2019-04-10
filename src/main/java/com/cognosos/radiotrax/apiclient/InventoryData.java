package com.cognosos.radiotrax.apiclient;

import java.util.HashMap;
import java.util.Map;

public class InventoryData {

    public static InventoryItem[] inventory = {
            new InventoryItem("A1001", "1FTFW1RG0HFA66295", "Ford", "F-150", "Raptor (3.5 V6) CREW CAB PICKUP 4-DR"),
            new InventoryItem("A1002", "1FTFW1CT8EFB42220", "Ford", "F-150", "SuperCrew (3.5L V6 TURBO), CREW CAB PICKUP 4-DR")
    };

    public static Map<String, String> getInventoryMap() {
        Map<String, String> inventoryMap = new HashMap<>();
        inventoryMap.put("asset_identifier", "A1001");
        inventoryMap.put("VIN", "1FTFW1RG0HFA66295");
        inventoryMap.put("Make", "Ford");
        inventoryMap.put("Model", "F-150");
        inventoryMap.put("Style", "Raptor (3.5 V6) CREW CAB PICKUP 4-DR");
        return inventoryMap;
    }
}

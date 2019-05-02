package com.cognosos.radiotrax.apiclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryData {

    public static InventoryItem[] inventory = {
            new InventoryItem("A1001", "1FTFW1RG0HFA66295", "Ford", "F-150", "Raptor (3.5 V6) CREW CAB PICKUP 4-DR", List.of(1)),
            new InventoryItem("A1002", "1FTFW1CT8EFB42220", "Ford", "F-150", "SuperCrew (3.5L V6 TURBO), CREW CAB PICKUP 4-DR", List.of(2,10))
    };

    // This should get the configured list of flags from the configuration file or other source
    // Once we have the integer -> name mapping, we can append them to outbound items.
    public static Map<Integer, String> getFlagMap() {
        var m = new HashMap<Integer, String>();
        m.put(1, "Needs Detailing");
        m.put(2, "Needs Carwash");
        m.put(10, "Needs Tire Patch");
        return m;
    }

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

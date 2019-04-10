package com.cognosos.radiotrax.apiclient;


public class InventoryItem {
    private String asset_identifier;
    private String VIN;
    private String Model;
    private String Make;
    private String Style;

    public InventoryItem(String id, String vin, String make, String model, String style) {
        asset_identifier = id;
        VIN = vin;
        Model = model;
        Make = make;
        Style = style;
    }

    public String getAsset_identifier() {
        return asset_identifier;
    }

    public void setAsset_identifier(String asset_identifier) {
        this.asset_identifier = asset_identifier;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getStyle() {
        return Style;
    }

    public void setStyle(String style) {
        Style = style;
    }
}

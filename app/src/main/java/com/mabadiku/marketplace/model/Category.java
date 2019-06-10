package com.mabadiku.marketplace.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Category {
    private int id;

    public Category(int id, String resourceImg, String name) {
        this.id = id;
        this.resourceImg = resourceImg;
        this.name = name;
    }
    public Category(JSONObject jsonObject){
        try {
            this.id = jsonObject.getInt("id");
            this.resourceImg = jsonObject.getString("imagePath");
            this.name = jsonObject.getString("nama");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourceImg() {
        return resourceImg;
    }

    public void setResourceImg(String resourceImg) {
        this.resourceImg = resourceImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String resourceImg;
    private String name;
}

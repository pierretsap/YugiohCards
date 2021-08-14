package com.example.YugiohCards.model;

import com.google.gson.annotations.SerializedName;

public class CardImage {
    @SerializedName("image_url")
    private String url;

    public CardImage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

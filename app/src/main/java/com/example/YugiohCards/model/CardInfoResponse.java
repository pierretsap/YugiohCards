package com.example.YugiohCards.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardInfoResponse {
    @SerializedName("data")
    private final List<CardInfo> data;

    public CardInfoResponse(List<CardInfo> data) {
        this.data = data;
    }

    public List<CardInfo> getData() {
        return data;
    }
}

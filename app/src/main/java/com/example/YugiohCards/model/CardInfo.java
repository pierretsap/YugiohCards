package com.example.YugiohCards.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardInfo {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("desc")
    private String desc;
    @SerializedName("type")
    private String type;
    @SerializedName("card_images")
    private List<CardImage> image;

    public List<CardImage> getImage() {
        return image;
    }

    public void setImage(List<CardImage> image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CardInfo(Integer id, String name, String desc, String type, List<CardImage> image) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

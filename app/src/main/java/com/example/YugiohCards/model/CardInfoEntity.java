package com.example.YugiohCards.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cards")
public class CardInfoEntity {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private final Integer id;

    @ColumnInfo(name = "name")
    private final String name;

    @ColumnInfo(name = "desc")
    private final String desc;

    @ColumnInfo(name = "type")
    private final String type;

    @ColumnInfo(name = "image")
    private final String image;

    public CardInfoEntity(Integer id, String name, String desc, String type, String image) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.image = image;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }

    public String getImage() {
        return image;
    }
}

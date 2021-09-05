package com.example.YugiohCards.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CardDao {
    @Query("SELECT * FROM cards")
    List<CardInfoEntity> getAll();

    @Insert
    void insert(CardInfoEntity cardInfo);

    @Query("SELECT * FROM cards where id like :id")
    CardInfoEntity getCard(int id);
}

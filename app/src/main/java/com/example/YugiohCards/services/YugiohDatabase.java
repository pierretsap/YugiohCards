package com.example.YugiohCards.services;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.YugiohCards.model.CardDao;
import com.example.YugiohCards.model.CardInfoEntity;

@Database(entities = {CardInfoEntity.class}, version = 1, exportSchema = false)
public abstract class YugiohDatabase extends RoomDatabase {

    public abstract CardDao cardDao();

    private static YugiohDatabase INSTANCE = null;

    public static YugiohDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (YugiohDatabase.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        YugiohDatabase.class,
                        "database")
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return INSTANCE;
    }
}

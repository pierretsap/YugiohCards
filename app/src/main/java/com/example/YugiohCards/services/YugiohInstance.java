package com.example.YugiohCards.services;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class YugiohInstance {
    private static Retrofit retrofit;
    private static final String YUGIOHURL = "https://db.ygoprodeck.com/api/v7/";

    public static Retrofit instance(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(YUGIOHURL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .build();
        }
        return retrofit;
    }
}

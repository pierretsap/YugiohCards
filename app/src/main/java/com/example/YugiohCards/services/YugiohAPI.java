package com.example.YugiohCards.services;

import com.example.YugiohCards.model.CardInfoResponse;

import io.reactivex.Single;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YugiohAPI {
    @GET("cardinfo.php")
    Single<CardInfoResponse> getCardInfo();

    @GET("cardinfo.php")
    Single<CardInfoResponse> searchCardsByName(@Query("name") String name);

    @GET("cardinfo.php")
    Single<CardInfoResponse> searchCardsById(@Query("id") Integer id);
}

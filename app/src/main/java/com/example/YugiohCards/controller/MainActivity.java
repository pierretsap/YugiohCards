package com.example.YugiohCards.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.YugiohCards.R;
import com.example.YugiohCards.model.CardInfoResponse;
import com.example.YugiohCards.services.YugiohInstance;
import com.example.YugiohCards.services.YugiohAPI;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private final static CompositeDisposable composite = new CompositeDisposable();
    private RecyclerView mRecyclerView;
    private CardInfoResponse cardResponse;


    public void getAllCards (){
        YugiohAPI yugiohApi = YugiohInstance.instance().create(YugiohAPI.class);
        composite.clear();
        composite.add(yugiohApi.getCardInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<CardInfoResponse>(){

                    @Override
                    public void onSuccess(CardInfoResponse cardInfos) {
                        displayCardInfo(cardInfos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("testcard", e.getMessage()+'\n'+e.getCause());
                    }
                }));
    }

    private void displayCardInfo(CardInfoResponse cardInfos) {
        mRecyclerView = findViewById(R.id.recycleView);
        MyAdapter adapter = new MyAdapter(MainActivity.this, cardInfos.getData());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setAdapter(adapter);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllCards();

    }
}
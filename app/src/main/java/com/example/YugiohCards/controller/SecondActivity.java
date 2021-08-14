package com.example.YugiohCards.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.YugiohCards.R;

public class SecondActivity extends AppCompatActivity {

    ImageView imageView;
    TextView nameView, typeView, descView;
    String name, type, desc, imageUrl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageView = findViewById(R.id.secondImage);
        nameView = findViewById(R.id.secondName);
        typeView = findViewById(R.id.secondType);
        descView = findViewById(R.id.secondDesc);

        getData();
        setData();
    }

    private void getData(){
        if (getIntent().hasExtra("sName")
                && getIntent().hasExtra("sType")
                && getIntent().hasExtra("sDesc")
                && getIntent().hasExtra("sImageUrl")){
            name = getIntent().getStringExtra("sName");
            type = getIntent().getStringExtra("sType");
            desc = getIntent().getStringExtra("sDesc");
            imageUrl = getIntent().getStringExtra("sImageUrl");
        }
    }

    private void setData(){
        nameView.setText(name);
        typeView.setText(type);
        descView.setText(desc);
        Glide.with(this).load(imageUrl).into(imageView);
    }
}
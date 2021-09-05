package com.example.YugiohCards.viewholder;

import android.view.View;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.YugiohCards.R;
import com.example.YugiohCards.model.CardInfo;

public class MyGridViewHolder extends MyViewHolder {

    public MyGridViewHolder(@NonNull View itemView) {
        super(itemView);
        cardImage = itemView.findViewById(R.id.card_grid_image);
    }

    @Override
    public void bind(CardInfo cardInfo){
        this.attachCardInfo(cardInfo);
        final String imageUrl = !cardInfo.getImage().isEmpty()?cardInfo.getImage().get(0).getUrl():"https://img.icons8.com/material-rounded/452/user-not-found.png";
        Glide.with(itemView).load(imageUrl).into(cardImage);
    }
}

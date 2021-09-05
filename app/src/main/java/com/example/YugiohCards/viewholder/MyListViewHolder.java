package com.example.YugiohCards.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.YugiohCards.R;
import com.example.YugiohCards.model.CardInfo;

public class MyListViewHolder  extends MyViewHolder {
    TextView cardName, cardType, cardDesc;

    public MyListViewHolder(@NonNull View itemView) {
        super(itemView);
        cardName = itemView.findViewById(R.id.card_name);
        cardType = itemView.findViewById(R.id.card_type);
        cardDesc = itemView.findViewById(R.id.card_desc);
        cardImage = itemView.findViewById(R.id.card_image);
    }

    @Override
    public void bind(CardInfo cardInfo) {
        this.attachCardInfo(cardInfo);
        cardName.setText(cardInfo.getName());
        cardType.setText(cardInfo.getType());
        if (cardInfo.getDesc().length() > 80){
            cardDesc.setText(cardInfo.getDesc().substring(0,80)+"...");
        } else {
            cardDesc.setText(cardInfo.getDesc());
        }
        final String imageUrl = !cardInfo.getImage().isEmpty()?cardInfo.getImage().get(0).getUrl():"https://img.icons8.com/material-rounded/452/user-not-found.png";
        Glide.with(itemView).load(imageUrl).into(cardImage);

    }
}
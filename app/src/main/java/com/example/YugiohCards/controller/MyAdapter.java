package com.example.YugiohCards.controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.YugiohCards.R;
import com.example.YugiohCards.model.CardInfo;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<CardInfo> cards;
    Context context;

    public MyAdapter(Context ct, List<CardInfo> cards){
        this.cards = cards;
        this.context = ct;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.general_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final CardInfo card = this.cards.get(position);
        final String imageUrl = !card.getImage().isEmpty()?card.getImage().get(0).getUrl():"https://img.icons8.com/material-rounded/452/user-not-found.png";
        holder.bind(card.getName(), card.getType(), card.getDesc(), imageUrl);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("sName", card.getName());
                intent.putExtra("sType", card.getType());
                intent.putExtra("sDesc", card.getDesc());
                intent.putExtra("sImageUrl", imageUrl);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.cards.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView cardName, cardType, cardDesc;
        ImageView cardImage;
        ConstraintLayout mainLayout;

        public void bind(String name, String type, String desc, String imageUrl){
            cardName.setText(name);
            cardType.setText(type);
            if (desc.length() > 100){
                cardDesc.setText(desc.substring(0,80)+"...");
            } else {
                cardDesc.setText(desc);
            }
            Glide.with(itemView).load(imageUrl).into(cardImage);
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardName = itemView.findViewById(R.id.card_name);
            cardType = itemView.findViewById(R.id.card_type);
            cardDesc = itemView.findViewById(R.id.card_desc);
            cardImage = itemView.findViewById(R.id.card_image);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}

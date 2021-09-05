package com.example.YugiohCards.adapter;

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
import com.example.YugiohCards.controller.SecondActivity;
import com.example.YugiohCards.model.CardInfoEntity;

import java.util.List;

public class VisitedAdapter extends RecyclerView.Adapter<VisitedAdapter.VViewHolder> {
    List<CardInfoEntity> cards;
    Context context;

    /**
     * Constructor
     */
    public VisitedAdapter(Context ct, List<CardInfoEntity> cards) {
        this.context = ct;
        this.cards = cards;
    }

    @NonNull
    @Override
    public VViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_general_row, parent, false);
        return new VViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VViewHolder holder, int position) {
        final CardInfoEntity cardInfo = this.cards.get(position);
        holder.bind(cardInfo);

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("sName", cardInfo.getName());
                intent.putExtra("sType", cardInfo.getType());
                intent.putExtra("sDesc", cardInfo.getDesc());
                intent.putExtra("sImageUrl", cardInfo.getImage());

                //send to the new entity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.cards.size();
    }

    public class VViewHolder extends RecyclerView.ViewHolder {


        TextView cardName, cardType, cardDesc;
        ImageView cardImage;
        ConstraintLayout mainLayout;

        public VViewHolder(@NonNull View itemView) {
            super(itemView);

            cardName = itemView.findViewById(R.id.card_name);
            cardType = itemView.findViewById(R.id.card_type);
            cardDesc = itemView.findViewById(R.id.card_desc);
            cardImage = itemView.findViewById(R.id.card_image);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

        public void bind(CardInfoEntity card){
            cardName.setText(card.getName());
            cardType.setText(card.getType());
            String desc = card.getDesc();
            if (desc.length() > 100) {
                cardDesc.setText(desc.substring(0,80)+"...");
            } else {
                cardDesc.setText(desc);
            }
            Glide.with(itemView).load(card.getImage()).into(cardImage);
        }
    }
}

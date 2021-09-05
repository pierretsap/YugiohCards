package com.example.YugiohCards.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.YugiohCards.fragment.MyView;
import com.example.YugiohCards.model.CardInfo;
import com.example.YugiohCards.viewholder.MyViewHolder;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<CardInfo> cards;
    MyView myView;

    /**
     * Constructor
     */
    public MyAdapter(MyView myView, List<CardInfo> cards){
        this.cards = cards;
        this.myView = myView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return this.myView.getCardView(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final CardInfo card = this.cards.get(position);
        holder.bind(card);
    }

    @Override
    public int getItemCount() {
        return this.cards.size();
    }
}

package com.example.YugiohCards.fragment;

import android.view.ViewGroup;

import com.example.YugiohCards.viewholder.MyViewHolder;

public interface MyView {
    /**
     * Gets the corresponding card view holder
     *
     * @param viewGroup the view associated to the holder view
     *
     * @return the card view holder
     */
    MyViewHolder getCardView(ViewGroup viewGroup);
}

package com.example.YugiohCards.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.YugiohCards.R;
import com.example.YugiohCards.adapter.VisitedAdapter;
import com.example.YugiohCards.model.CardInfoEntity;
import com.example.YugiohCards.services.YugiohDatabase;

import java.util.List;

public class VisitedFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private View rootView;
    private YugiohDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle savedInstance){
        super.onCreateView(inflater, view, savedInstance);
        database = YugiohDatabase.getInstance(getContext());
        rootView = inflater.inflate(R.layout.fragment_list, view, false);
        displayVisitedCards();
        return rootView;
    }

    /**
     * Displays the visited cards
     */
    public void displayVisitedCards() {
        List<CardInfoEntity> visitedCards = database.cardDao().getAll();

        mRecyclerView = rootView.findViewById(R.id.recycleView);
        VisitedAdapter adapter = new VisitedAdapter(this.getContext(), visitedCards);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mRecyclerView.setAdapter(adapter);
    }
}

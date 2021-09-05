package com.example.YugiohCards.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.YugiohCards.R;
import com.example.YugiohCards.adapter.MyAdapter;
import com.example.YugiohCards.model.CardInfoResponse;
import com.example.YugiohCards.services.YugiohAPI;
import com.example.YugiohCards.services.YugiohInstance;
import com.example.YugiohCards.viewholder.MyGridViewHolder;
import com.example.YugiohCards.viewholder.MyViewHolder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class GridFragment extends Fragment implements MyView {
    private final static CompositeDisposable composite = new CompositeDisposable();
    private RecyclerView mRecyclerView;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle savedInstance){
        super.onCreateView(inflater, view, savedInstance);
        rootView = inflater.inflate(R.layout.fragment_list, view, false);
        getAllCards();
        return rootView;
    }

    /**
     * Gets all cards from the api
     */
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

    /**
     * Displays card's informations in a new screen
     *
     * @param cardInfos the card to display
     */
    private void displayCardInfo(CardInfoResponse cardInfos) {
        mRecyclerView = rootView.findViewById(R.id.recycleView);
        MyAdapter adapter = new MyAdapter(this, cardInfos.getData());

        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 3));
        mRecyclerView.setAdapter(adapter);
    }


    @Override
    public MyViewHolder getCardView(ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(this.getActivity());
        View view = inflater.inflate(R.layout.grid_general_row, viewGroup, false);
        return new MyGridViewHolder(view);
    }
}

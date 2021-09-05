package com.example.YugiohCards.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.YugiohCards.R;
import com.example.YugiohCards.controller.SecondActivity;
import com.example.YugiohCards.model.CardDao;
import com.example.YugiohCards.model.CardInfo;
import com.example.YugiohCards.model.CardInfoEntity;
import com.example.YugiohCards.services.YugiohDatabase;

public abstract class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView cardImage;
    ConstraintLayout mainLayout;
    @NonNull
    CardInfo cardInfo;

    public MyViewHolder(@NonNull final View itemView) {
        super(itemView);
        mainLayout = itemView.findViewById(R.id.mainLayout);
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(itemView.getContext(), SecondActivity.class);
                intent.putExtra("sName", cardInfo.getName());
                intent.putExtra("sType", cardInfo.getType());
                intent.putExtra("sDesc", cardInfo.getDesc());
                final String imageUrl = !cardInfo.getImage().isEmpty()?cardInfo.getImage().get(0).getUrl():"https://img.icons8.com/material-rounded/452/user-not-found.png";
                intent.putExtra("sImageUrl", imageUrl);

                //insert card in database
                YugiohDatabase database = YugiohDatabase.getInstance(itemView.getContext());
                CardInfoEntity cardInfoEntity = new CardInfoEntity(
                    cardInfo.getId(),
                    cardInfo.getName(),
                    cardInfo.getDesc(),
                    cardInfo.getType(),
                    imageUrl
                );

                CardDao dao = database.cardDao();
                if (dao.getCard(cardInfo.getId()) == null)
                    dao.insert(cardInfoEntity);

                //send to the new entity
                itemView.getContext().startActivity(intent);
            }
        });
    }

    protected void attachCardInfo(CardInfo cardInfo){
        this.cardInfo = cardInfo;
    }

    public abstract void bind(CardInfo cardInfo);
}

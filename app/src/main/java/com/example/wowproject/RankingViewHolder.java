package com.example.wowproject;

import android.content.Context;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RankingViewHolder extends RecyclerView.ViewHolder {


    private Context mContext;
    private TextView name;
    private TextView ilvl;
    private TextView total;
    private TextView duration;


    public RankingViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.rankingName);
        ilvl = itemView.findViewById(R.id.rankingilvl);
        total=itemView.findViewById(R.id.rankingSpec);
        duration=itemView.findViewById(R.id.rankingDuration);

    }

        void display(final ListRanking maList, final Context context){
            mContext = context;
            name.setText(maList.getName());
            ilvl.setText(Double.toString(maList.getItemLevel()) + " iLvl");
            total.setText(Double.toString(maList.getTotal()) + " DPS ");
            double temps1 = maList.getDuration()/60000;

            DecimalFormat df = new DecimalFormat ( ) ;
            df.setMaximumFractionDigits ( 2 ) ;
            df.setMinimumFractionDigits ( 2 ) ;
            double temps= Double.parseDouble(df.format(temps1));
            duration.setText(Double.toString(temps) + " min");

    }
}



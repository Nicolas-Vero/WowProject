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
import java.util.ArrayList;
import java.util.List;

public class EncounterViewHolder extends RecyclerView.ViewHolder  {


    private Context mContext;
    private TextView name;
    private ImageView imageUrl;
    private View encounterView;


    public EncounterViewHolder(@NonNull View itemView ) {
        super(itemView);

        name = itemView.findViewById(R.id.encounter_name);
        imageUrl=itemView.findViewById(R.id.ImageEncounter);
        encounterView=itemView.findViewById(R.id.EncounterParent);
    }

    void display(final ListEncounters maList, final Context context){
        mContext=context;
        name.setText(maList.getName());
        Picasso.with(context).load("https://dmszsuqyoe6y6.cloudfront.net/img/warcraft/bosses/"+ maList.getId() + "-icon.jpg").into(imageUrl);

    }
}



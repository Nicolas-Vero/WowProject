package com.example.wowproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.content.Intent;
import android.widget.AdapterView;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EncounterViewAdapter extends  RecyclerView.Adapter<EncounterViewHolder> {



    private List<ListEncounters> maList;
    private Context mContext;
    public EncounterViewAdapter(List<ListEncounters> maList, Context context){
        this.maList = maList;
        this.mContext=context;
    }
    @NonNull
    @Override
    public EncounterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_encounter,parent, false);
        return new EncounterViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull EncounterViewHolder holder, int position) {
        holder.display(maList.get(position), mContext);
    }
    @Override
    public int getItemCount() {
        return maList.size();
    }
}


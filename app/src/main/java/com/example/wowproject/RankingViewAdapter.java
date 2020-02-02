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

public class RankingViewAdapter extends  RecyclerView.Adapter<RankingViewHolder> {



    private List<ListRanking> maList;
    private Context mContext;
    public RankingViewAdapter(List<ListRanking> maList, Context context){
        this.maList = maList;
        this.mContext=context;
    }
    @NonNull
    @Override
    public RankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ranking,parent, false);
        return new RankingViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RankingViewHolder holder, int position) {
        holder.display(maList.get(position), mContext);
    }
    @Override
    public int getItemCount() {
        return maList.size();
    }
}


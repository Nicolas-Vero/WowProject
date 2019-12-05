package com.example.wowproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Callback;
import java.util.List;

public class WowZoneViewAdapter extends  RecyclerView.Adapter<WowZoneViewHolder> {



        private List<ListZone> maList;
        private Context mContext;
        public WowZoneViewAdapter(List<ListZone> maList, Context context) {
            this.maList = maList;
            this.mContext = context;
        }
        @NonNull
        @Override
        public WowZoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zone,parent, false);
            return new WowZoneViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull WowZoneViewHolder holder, int position) {
            holder.display(maList.get(position),mContext);

        }

        @Override
        public int getItemCount() {
            return maList.size();
        }
    }


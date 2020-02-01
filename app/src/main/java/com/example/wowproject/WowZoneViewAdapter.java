package com.example.wowproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.content.Intent;
import android.widget.AdapterView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WowZoneViewAdapter extends  RecyclerView.Adapter< WowZoneViewHolder> implements Filterable {

        private List<ListZone> maList;
        private List<ListZone> maListFULL;
        private Context mContext;
        public WowZoneViewAdapter(List<ListZone> maList, Context context){
            this.maList = maList;
            this.mContext=context;
            maListFULL = new ArrayList<>(maList);
        }
        @NonNull
        @Override
        public WowZoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.zone,parent, false);
            return new WowZoneViewHolder(view);
        }
        @Override
        public void onBindViewHolder(@NonNull WowZoneViewHolder holder, int position) {
            holder.display(maList.get(position), mContext);
        }
        @Override
        public int getItemCount() {
            return maList.size();
        }

        @Override
        public Filter getFilter() {
            return listFilter;
        }
        private Filter listFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<ListZone> filteredList = new ArrayList<>();
               if (constraint==null||constraint.length()== 0){
                   filteredList.addAll(maListFULL);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (ListZone zone: maListFULL){
                 if (zone.getName().toLowerCase().contains(filterPattern)){
                     filteredList.add(zone);
                 }
                 }
                }
               FilterResults results = new FilterResults();
               results.values = filteredList;
               return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                maList.clear();
                maList.addAll((List) results.values);
                notifyDataSetChanged();
            }
        };
    }


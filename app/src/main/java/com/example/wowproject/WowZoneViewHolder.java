package com.example.wowproject;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WowZoneViewHolder extends RecyclerView.ViewHolder  {


        private Context mContext  ;
        private TextView name;

        public WowZoneViewHolder(@NonNull View itemView ) {
            super(itemView);

            name = itemView.findViewById(R.id.zone);
            //mWebview = itemView.findViewById(R.id.webview);
        }

        void display(ListZone maList,Context context){
            mContext = context;
            name.setText(maList.getRepoName());
        }
    }



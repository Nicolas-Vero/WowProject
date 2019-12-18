package com.example.wowproject;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WowZoneViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private View zoneView;

    public WowZoneViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.zoneTv);
        zoneView = itemView.findViewById(R.id.zoneViewParent);
        //mWebview = itemView.findViewById(R.id.webview);

    }

    void display(final ListZone maList, final Context context) {
        name.setText(maList.getName());

        zoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewActivity.class);
                intent.putExtra("ZONE_NAME", maList.getName());
                intent.putExtra("ZONE_ID", maList.getId());
                context.startActivity(intent);
            }
        });
    }

}



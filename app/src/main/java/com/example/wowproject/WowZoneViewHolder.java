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

public class WowZoneViewHolder extends RecyclerView.ViewHolder  {


        private Context mContext;
        private TextView name;
        private ImageView imageUrl;
        private View zoneView;


        public WowZoneViewHolder(@NonNull View itemView ) {
            super(itemView);

            name = itemView.findViewById(R.id.zoneTV);
            imageUrl=itemView.findViewById(R.id.imageView);
            zoneView=itemView.findViewById(R.id.zoneViewParent);
        }

        void display(final ListZone maList, final Context context){
            mContext=context;
            name.setText(maList.getName());
            Picasso.get().load("https://dmszsuqyoe6y6.cloudfront.net/img/warcraft/zones/zone-"+maList.getId()+"-small.jpg").into(imageUrl);

           zoneView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, EncounterActivity.class);
                    intent.putExtra("ZONE_NAME", maList.getName());
                    List<ListEncounters> encounters=maList.getEncounters();
                    intent.putExtra("encounters",(Serializable) encounters );
                    context.startActivity(intent);
                }
            });
        }
    }



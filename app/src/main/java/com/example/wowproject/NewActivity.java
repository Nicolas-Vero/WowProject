package com.example.wowproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.zonedetails);
        getIncomingIntent();


    }


    private void getIncomingIntent(){
        if(getIntent().hasExtra("ZONE_NAME")&& getIntent().hasExtra("ZONE_ID")){


            String zoneName = getIntent().getStringExtra("ZONE_NAME");
            Integer zoneID = getIntent().getIntExtra("ZONE_ID",0);
            setIncomingIntent(zoneName ,zoneID);
        }

    }

    private void  setIncomingIntent(String zoneName ,Integer  zoneID){
       // Toast.makeText(NewActivity.this, zoneID, Toast.LENGTH_LONG).show();

        Toast.makeText(NewActivity.this, zoneName, Toast.LENGTH_LONG).show();
    //    Toast.makeText(NewActivity.this, zoneID, Toast.LENGTH_LONG).show();

        TextView name = findViewById(R.id.zone_name);
        name.setText(zoneName);
     //   TextView id = findViewById(R.id.zone_id);
     //   id.setText(zoneID);

    }
}

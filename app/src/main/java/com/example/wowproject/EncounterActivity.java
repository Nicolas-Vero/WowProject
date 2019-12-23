package com.example.wowproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EncounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encounter);

        Intent intent=getIntent();
        String nom;
        List<ListEncounters> encounter;
        encounter= (List<ListEncounters>) intent.getSerializableExtra("encounters");
        nom=intent.getStringExtra("ZONE_NAME");
       /* TextView text=findViewById(R.id.encounter_name);
        text.setText(nom);*/
        TextView noom=findViewById(R.id.encounter_id);

        for(int i=1;i<encounter.size();i++){

            noom.setText(encounter.get(i).getName());
        }







    }
}

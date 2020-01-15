package com.example.wowproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        setContentView(R.layout.encounter_rv);

        Intent intent=getIntent();
        String nom;
        List<ListEncounters> encounter;
        encounter= (List<ListEncounters>) intent.getSerializableExtra("encounters");

        RecyclerView myRecyclerView = findViewById(R.id.encounterRV);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(EncounterActivity.this));
        myRecyclerView.setAdapter( new EncounterViewAdapter(encounter,EncounterActivity.this));








    }
}

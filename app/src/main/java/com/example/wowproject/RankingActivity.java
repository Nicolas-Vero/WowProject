package com.example.wowproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_rv);
        Intent intent = getIntent();
        String nom= intent.getStringExtra("ZONE_NAME");
        int encounterID=intent.getIntExtra("ZONE_ID",0);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://www.warcraftlogs.com/v1/")
                .addConverterFactory(GsonConverterFactory.create());


        Retrofit retrofit = builder.build();
        Ranks service = retrofit.create(Ranks.class);
        Call<ListRankings> call = service.UserRepositories(encounterID,"4e3daef46dae06b521b4590861c6dca5");
        call.enqueue(new Callback<ListRankings>() {
            @Override
            public void onResponse(Call<ListRankings> call, Response<ListRankings> response) {
                ListRankings list = response.body();
                RecyclerView rankingRV = findViewById(R.id.rankingRV);
                rankingRV.setLayoutManager(new LinearLayoutManager(RankingActivity.this));
               rankingRV.setAdapter( new RankingViewAdapter(list.getRankings(),RankingActivity.this));
            }
            @Override
            public void onFailure(Call<ListRankings> call, Throwable t) {
                Toast.makeText(RankingActivity.this, "Error...!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

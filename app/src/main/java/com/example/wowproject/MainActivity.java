package com.example.wowproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://www.warcraftlogs.com/v1/")
                .addConverterFactory(GsonConverterFactory.create());


        Retrofit retrofit = builder.build();
        WarcraftService service = retrofit.create(WarcraftService.class);
        Call<List<ListZone>> call = service.UserRepositories();
        call.enqueue(new Callback<List<ListZone>>() {
            @Override
            public void onResponse(Call<List<ListZone>> call, Response<List<ListZone>> response) {
                List<ListZone> list = response.body();
                RecyclerView myRecyclerView = findViewById(R.id.myRecyclerView);
                myRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                myRecyclerView.setAdapter( new WowZoneViewAdapter(list,MainActivity.this));


            }
            @Override
            public void onFailure(Call<List<ListZone>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error...!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

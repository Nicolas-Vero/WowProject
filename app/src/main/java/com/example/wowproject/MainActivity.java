package com.example.wowproject;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private WowZoneViewAdapter adapter;


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
               // myRecyclerView.setAdapter( new WowZoneViewAdapter(list,MainActivity.this));
                adapter = new WowZoneViewAdapter(list,MainActivity.this);
                myRecyclerView.setAdapter(adapter);

            }
            @Override
            public void onFailure(Call<List<ListZone>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error...!!!", Toast.LENGTH_SHORT).show();
            }

        });


    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                  adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


}

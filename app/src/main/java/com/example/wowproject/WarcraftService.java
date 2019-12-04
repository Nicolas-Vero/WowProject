package com.example.wowproject;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.Call;

public interface WarcraftService {
    @GET("zones?api_key=4e3daef46dae06b521b4590861c6dca5")
    Call<List<ListZone>> UserRepositories();
}


package com.example.wowproject;

import android.content.Intent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Ranks {

    @GET("rankings/encounter/{encounterID}")
    Call<ListRankings> UserRepositories(@Path("encounterID") int encounterID,@Query("api_key") String apiKey);
}

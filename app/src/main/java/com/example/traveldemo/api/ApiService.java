package com.example.traveldemo.api;

import com.example.traveldemo.ui.home.tabhome.list_tourist.adapter.ContactTopFavorites;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder().baseUrl("https://demo6461759.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build().create(ApiService.class);
    @GET("travelDemo")
    Call<List<ContactTopFavorites>> getList();
}

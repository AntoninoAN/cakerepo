package com.example.cakerecipes.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CakeApiInterface {
    @GET("cake.json")
    Call<List<CakeDetailsPojo>> getCakeList();
}

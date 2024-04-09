package com.mohanraj.newsfeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String Base_url = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<mainnews> getNews(

            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey


    );

    @GET("top-headlines")
    Call<mainnews> getCatogoryNews(

            @Query("country") String country,
            @Query("category") String catogory,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey


            );

}

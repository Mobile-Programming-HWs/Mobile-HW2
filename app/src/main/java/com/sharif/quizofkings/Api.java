package com.sharif.quizofkings;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://opentdb.com/";
    @GET("api.php")
    Call<String> getGame(@Query("amount") int amount, @Query("difficulty") String dif, @Query("category") int cat, @Query("type") String tp);
}
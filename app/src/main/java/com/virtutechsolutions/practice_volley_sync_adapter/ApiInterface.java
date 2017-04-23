package com.virtutechsolutions.practice_volley_sync_adapter;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mallikarjuna on 20-04-2017.
 */

public interface ApiInterface {

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String Api_Key);

    @GET("movie/{id}")
    Call<MoviesResponse>  getMoviesList(@Path("id") int id,@Query("api_key") String Api_Key);
}

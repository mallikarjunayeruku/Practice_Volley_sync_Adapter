package com.virtutechsolutions.practice_volley_sync_adapter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mallikarjuna on 20-04-2017.
 */

public class ApiClient {
    public  static Retrofit retrofit=null;
    public  static String BaseUrl="http://api.themoviedb.org/3/";

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            ;

        }
        return retrofit;
    }
}

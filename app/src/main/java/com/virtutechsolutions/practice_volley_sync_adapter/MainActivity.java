package com.virtutechsolutions.practice_volley_sync_adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
/*
    TextView textView;
    RequestQueue requestQueue;
    StringRequest stringRequest;
    String TAG="TAG";
    boolean b=true;*/
private String Api_Key;

RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Api_Key=getResources().getString(R.string.tmdb_api_key);

        recyclerView= (RecyclerView) findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);

        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);

        Call<MoviesResponse> call=apiInterface.getTopRatedMovies(Api_Key);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {

                List<Movie> movies=response.body().getResults();
                recyclerView.setAdapter(new CustomHolder(MainActivity.this,movies));
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });

/*
        textView= (TextView) findViewById(R.id.tx);


        Cache cache=new DiskBasedCache(getCacheDir(),1024*1024);

        Network network=new BasicNetwork(new HurlStack());
        requestQueue= new RequestQueue(cache,network);
        requestQueue.start();


         stringRequest=new StringRequest(Request.Method.GET, "http://zacpoonen.in/api/articles", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(response);
            }

        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Error");
            }
        });
        stringRequest.setTag(TAG);
*/





    }
    /*public void Call_Api(View view)
    {
        if(b){
            requestQueue.add(stringRequest);
            b=false;
        }
        else
        {
            requestQueue.cancelAll(TAG);
            b=true;
        }

    }*/
}

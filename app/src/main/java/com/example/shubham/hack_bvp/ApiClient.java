package com.example.shubham.hack_bvp;

import android.util.Log;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shubham on 2/2/17.
 */

public class ApiClient {
    static ApiService apiService;

    public static ApiService getApiService() {



        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("HttpStatus",message);
            }
        });

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);



        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        Retrofit r=new Retrofit.Builder().baseUrl("http://192.168.43.66")
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).client(okHttpClient).build();

        apiService=r.create(ApiService.class);

        return apiService;
    }


}

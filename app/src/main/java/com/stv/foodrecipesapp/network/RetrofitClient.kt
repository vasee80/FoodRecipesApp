package com.stv.foodrecipesapp.network

import com.google.gson.GsonBuilder
import com.stv.foodrecipesapp.util.AppContants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        val retrofit: ApiService = Retrofit.Builder()
            .baseUrl(AppContants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(ApiService::class.java)
    }
}
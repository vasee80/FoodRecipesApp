package com.stv.foodrecipesapp.network

import com.stv.foodrecipesapp.network.responses.RecipeResponse
import com.stv.foodrecipesapp.network.responses.RecipeSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/search")
    fun searchRecipe(
        @Query("key") key: String,
        @Query("q") query: String,
        @Query("page") page: String
    ): Call<RecipeSearchResponse>

    @GET("api/get")
    fun getRecipe(
        @Query("key") key: String,
        @Query("rId") recipeId: String
    ): Call<RecipeResponse>
}

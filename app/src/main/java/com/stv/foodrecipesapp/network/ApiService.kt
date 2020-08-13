package com.stv.foodrecipesapp.network

import com.stv.foodrecipesapp.network.responses.RecipeResponse
import com.stv.foodrecipesapp.network.responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/get")
    suspend fun getRecipe(
        @Query("key") key: String,
        @Query("rId") recipeId: String
    ): RecipeResponse

    @GET("api/search")
    suspend fun searchRecipes(
        @Query("key") key: String,
        @Query("q") query: String,
        @Query("page") page: String
    ): RecipeSearchResponse
}

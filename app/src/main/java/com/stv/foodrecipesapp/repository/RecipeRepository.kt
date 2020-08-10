package com.stv.foodrecipesapp.repository

import androidx.lifecycle.LiveData
import com.stv.foodrecipesapp.model.Recipe
import com.stv.foodrecipesapp.network.ApiClient
import com.stv.foodrecipesapp.network.ApiService
import com.stv.foodrecipesapp.network.RetrofitClient
import com.stv.foodrecipesapp.util.AppContants

class RecipeRepository {

    private val apiClient: ApiClient = ApiClient.getInstance()

    var client: ApiService = RetrofitClient.retrofit

    fun getRecipes(): LiveData<List<Recipe>> {
        return apiClient.mRecipes
    }

    suspend fun searchRecipe(query: String, page: Int) {
        if (page == 0) {
            page.and(1)
        }

        //apiClient.searchRecipe(query, page)

        client.searchRecipe(AppContants.API_KEY, query, page.toString())
    }

    suspend fun searchRecipes(
        query: String,
        page: Int
    ) = client.searchRecipes(AppContants.API_KEY, query, page.toString())


    companion object {
        private var INSTANCE: RecipeRepository? = null
        fun getInstance() = INSTANCE
            ?: RecipeRepository().also {
                INSTANCE = it
            }
    }
}
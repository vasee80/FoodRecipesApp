package com.stv.foodrecipesapp.repository

import androidx.lifecycle.LiveData
import com.stv.foodrecipesapp.model.Recipe
import com.stv.foodrecipesapp.network.ApiClient
import com.stv.foodrecipesapp.network.ApiService
import com.stv.foodrecipesapp.network.RetrofitClient
import com.stv.foodrecipesapp.network.responses.RecipeSearchResponse
import com.stv.foodrecipesapp.util.AppContants
import kotlin.properties.Delegates

class RecipeRepository {

    private val apiClient: ApiClient = ApiClient.getInstance()
    private lateinit var mQuery: String
    private var mPageNumber by Delegates.notNull<Int>()

    var client: ApiService = RetrofitClient.retrofit

    fun getRecipes(): LiveData<List<Recipe>> {
        return apiClient.mRecipes
    }

    suspend fun searchRecipes(
        query: String,
        page: Int
    ): RecipeSearchResponse {
        this.mQuery = query
        this.mPageNumber = page
        return client.searchRecipes(AppContants.API_KEY, query, page.toString())
    }

    suspend fun searchNextPage(): RecipeSearchResponse {
        return searchRecipes(mQuery, mPageNumber + 1)
    }

    companion object {
        private var INSTANCE: RecipeRepository? = null
        fun getInstance() = INSTANCE
            ?: RecipeRepository().also {
                INSTANCE = it
            }
    }
}
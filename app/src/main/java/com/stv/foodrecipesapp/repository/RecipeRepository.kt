package com.stv.foodrecipesapp.repository

import androidx.lifecycle.LiveData
import com.stv.foodrecipesapp.model.Recipe
import com.stv.foodrecipesapp.network.ApiClient

class RecipeRepository {

    private val apiClient: ApiClient = ApiClient.getInstance()

    fun getRecipes(): LiveData<List<Recipe>>{
        return apiClient.mRecipes
    }

    fun searchRecipe(query: String, page: Int){
        if(page == 0) {
            page.and(1)
        }

        apiClient.searchRecipe(query, page)
    }

    companion object {
        private var INSTANCE: RecipeRepository? = null
        fun getInstance() = INSTANCE
            ?: RecipeRepository().also {
                INSTANCE = it
            }
    }
}
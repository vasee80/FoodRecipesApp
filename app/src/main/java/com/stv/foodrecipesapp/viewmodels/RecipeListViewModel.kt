package com.stv.foodrecipesapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.stv.foodrecipesapp.model.Recipe
import com.stv.foodrecipesapp.repository.RecipeRepository

class RecipeListViewModel: ViewModel() {

    private val recipeRepository: RecipeRepository = RecipeRepository.getInstance()

    val mRecipe : LiveData<List<Recipe>>
    get() = recipeRepository.getRecipes()

    fun searchRecipe(query: String, page: Int){
        recipeRepository.searchRecipe(query, page)
    }

}
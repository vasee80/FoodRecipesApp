package com.stv.foodrecipesapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.stv.foodrecipesapp.model.Recipe
import com.stv.foodrecipesapp.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers

class RecipeListViewModel : ViewModel() {

    private val recipeRepository: RecipeRepository = RecipeRepository.getInstance()

    var isViewCategory: Boolean = false

    val mRecipe: LiveData<List<Recipe>>
        get() = recipeRepository.getRecipes()

    fun searchRecipes(
        query: String,
        page: Int
    ) = liveData(Dispatchers.IO) {
        isViewCategory = true
        val retriveRecipeAbstractMutableList = recipeRepository.searchRecipes(query, page)
        emit(retriveRecipeAbstractMutableList.recipes)
    }

}
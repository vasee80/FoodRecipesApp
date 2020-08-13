package com.stv.foodrecipesapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.stv.foodrecipesapp.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers

class RecipeViewModel : ViewModel() {

    private val recipeRepository: RecipeRepository = RecipeRepository.getInstance()
    var isViewingRecipePage: Boolean = false

    fun getRecipe(
        recipeId: String
    ) = liveData(Dispatchers.IO) {
        isViewingRecipePage = true
        val retriveRecipeResult = recipeRepository.getRecipe(recipeId)
        emit(retriveRecipeResult.recipe)
    }

    fun onBackPressed(): Boolean {
        if (isViewingRecipePage) {
            isViewingRecipePage = false
            return false
        }
        return true
    }
}
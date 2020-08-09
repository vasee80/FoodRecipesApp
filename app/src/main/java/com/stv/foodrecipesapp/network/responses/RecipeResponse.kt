package com.stv.foodrecipesapp.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.stv.foodrecipesapp.model.Recipe

data class RecipeResponse(
    @SerializedName("recipe") @Expose var recipe: Recipe
)
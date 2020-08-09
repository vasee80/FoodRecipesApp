package com.stv.foodrecipesapp.network.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.stv.foodrecipesapp.model.Recipe

data class RecipeSearchResponse (
    @SerializedName("count") @Expose var count: Int,
    @SerializedName("recipes") @Expose var recipes: List<Recipe>
)
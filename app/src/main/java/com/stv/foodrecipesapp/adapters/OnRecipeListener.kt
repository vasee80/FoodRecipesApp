package com.stv.foodrecipesapp.adapters

interface OnRecipeListener {
    fun onRecipeClick(position: Int)

    fun onCategoryClick(category: String?)
}
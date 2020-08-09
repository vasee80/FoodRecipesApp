package com.stv.foodrecipesapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stv.foodrecipesapp.model.Recipe
import com.stv.foodrecipesapp.viewmodels.RecipeListViewModel

class RecipeListActivity : BaseActivity() {
    private val TAG = "RecipeListActivity"

    private lateinit var recipeListViewModel: RecipeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        recipeListViewModel = ViewModelProvider(this).get(RecipeListViewModel::class.java)

        findViewById<Button>(R.id.testBttn).setOnClickListener {
            //showProgressbar(progressBar.visibility == View.GONE)
            testNetworkApi()
        }

        subscribeObservers()
    }

    private fun subscribeObservers(){
        recipeListViewModel.mRecipe.observe(this, Observer {
            for (recipe: Recipe in it){
                Log.d(TAG, "subscribeObservers recipe title: ${recipe.title}")
            }
        })
    }

    private fun searchRecipe(query: String, page: Int){
        recipeListViewModel.searchRecipe(query, page)
    }

    private fun testNetworkApi(){
        searchRecipe("chicken breast",1)
    }
}
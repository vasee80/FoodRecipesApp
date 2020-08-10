package com.stv.foodrecipesapp

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stv.foodrecipesapp.adapters.OnRecipeListener
import com.stv.foodrecipesapp.adapters.RecipeRecyclerAdapter
import com.stv.foodrecipesapp.model.Recipe
import com.stv.foodrecipesapp.viewmodels.RecipeListViewModel

class RecipeListActivity : BaseActivity(), OnRecipeListener {
    private val TAG = "RecipeListActivity"

    private lateinit var recipeListViewModel: RecipeListViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeRecyclerAdapter: RecipeRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
        recyclerView = findViewById(R.id.recipe_list)

        recipeListViewModel = ViewModelProvider(this).get(RecipeListViewModel::class.java)

        initRecyclerView()
        testNetworkApi()
    }

    private fun searchRecipe(query: String, page: Int) {
        recipeListViewModel.searchRecipes(query, page).observe(this, Observer {
            for (recipe: Recipe in it) {
                Log.d(TAG, "subscribeObservers recipe title: ${recipe.title}")
            }
            recipeRecyclerAdapter.setRecipesList(it)
        })
    }

    private fun initRecyclerView() {
        recipeRecyclerAdapter = RecipeRecyclerAdapter(this)
        recyclerView.adapter = recipeRecyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun testNetworkApi() {
        searchRecipe("chicken breast", 1)
    }

    override fun onRecipeClick(position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCategoryClick(category: String?) {
        TODO("Not yet implemented")
    }
}
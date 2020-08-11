package com.stv.foodrecipesapp

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
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
        initSearchView()

        if (!recipeListViewModel.isViewCategory) {
            //display search categories
            displaySearchCategories()
        }
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
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            ).also { deco ->
                with(ShapeDrawable(RectShape())) {
                    intrinsicHeight = (resources.displayMetrics.density * 24).toInt()
                    alpha = 0
                    deco.setDrawable(this)
                }
            })
    }

    private fun initSearchView() {
        val searchView: SearchView = findViewById(R.id.search_view)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    recipeRecyclerAdapter.displayLoading()
                    searchRecipe(query, 1)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }

        })
    }

    override fun onRecipeClick(position: Int) {

    }

    override fun onCategoryClick(category: String?) {
        recipeRecyclerAdapter.displayLoading()
        if (category != null) {
            searchRecipe(category, 1)
        }
    }

    private fun displaySearchCategories() {
        recipeListViewModel.isViewCategory = false
        recipeRecyclerAdapter.displaySearchCategoties()
    }
}
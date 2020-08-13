package com.stv.foodrecipesapp.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stv.foodrecipesapp.model.Recipe

class ApiClient {

    private val TAG = "ApiClient"

    private var _mRecipes: MutableLiveData<List<Recipe>> = MutableLiveData()

    //private lateinit var retrieveRecipeRunnable: RetrieveRecipeRunnable

    val mRecipes: LiveData<List<Recipe>>
        get() = _mRecipes

    suspend fun searchRecipe(query: String, page: Int) {
        /*ServiceGenerator.recipeApi.searchRecipe(
            AppContants.API_KEY,
            query,
            page.toString()
        )*/
    }
    /*fun searchRecipe(query: String, page: Int){

        retrieveRecipeRunnable = RetrieveRecipeRunnable(query, page)

        val handler = AppExecutors.getInstance().networkIO().submit(retrieveRecipeRunnable)

        AppExecutors.getInstance().networkIO().schedule({
            handler.cancel(true)
        }, AppContants.REQUEST_TIMEOUT_DURATION, TimeUnit.MILLISECONDS)
    }

    inner class RetrieveRecipeRunnable constructor(private val query: String, private val page: Int) : Runnable{
        var cancelRequest: Boolean = false

        override fun run() {
            val response = getRecipes(query, page).execute()
            if (cancelRequest) return

            if(response.code() == 200){
                val list: List<Recipe> = response.body()!!.recipes
                if (page == 1) {
                    _mRecipes.postValue(list)
                }
                else {
                    var currentList: MutableList<Recipe> = _mRecipes.value as MutableList<Recipe>
                    currentList.addAll(list)
                    _mRecipes.postValue(currentList)
                }
            }else{
                Log.d(TAG, "run: ${response.errorBody().toString()}")
                _mRecipes.postValue(null)
            }
        }

        private fun getRecipes(query: String, page: Int): Call<RecipeSearchResponse>{
            return ServiceGenerator.recipeApi.searchRecipe(
                AppContants.API_KEY,
                query,
                page.toString()
            )
        }

        private fun cancelRequest(){
            Log.d(TAG, "cancelRequest: canceling the request")
            cancelRequest = true
        }
    }*/

    companion object {
        private var INSTANCE: ApiClient? = null
        fun getInstance() = INSTANCE
            ?: ApiClient().also {
                INSTANCE = it
            }
    }
}
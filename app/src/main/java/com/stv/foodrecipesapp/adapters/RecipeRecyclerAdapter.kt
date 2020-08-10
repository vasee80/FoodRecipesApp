package com.stv.foodrecipesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.stv.foodrecipesapp.R
import com.stv.foodrecipesapp.model.Recipe
import kotlin.math.roundToInt

class RecipeRecyclerAdapter(
    onRecipeListener: OnRecipeListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mRecipeList: List<Recipe> = ArrayList()
    private var mOnRecipeListener: OnRecipeListener = onRecipeListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recipe_list_item, parent, false)
        return RecipeViewHolder(view, mOnRecipeListener)
    }

    override fun getItemCount(): Int {
        return if (mRecipeList != null) {
            mRecipeList.size
        } else {
            1
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val requestOptions: RequestOptions =
            RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher_background)

        Glide.with(holder.itemView.context).setDefaultRequestOptions(requestOptions)
            .load(mRecipeList[position].image_url)
            .into((holder as RecipeViewHolder).image)

        holder.title.text = mRecipeList[position].title
        holder.publisher.text = mRecipeList[position].publisher
        holder.socialScore.text =
            mRecipeList[position].social_rank.roundToInt().toString()
    }

    fun setRecipesList(list: List<Recipe>) {
        mRecipeList = list
        notifyDataSetChanged()
    }
}
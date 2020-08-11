package com.stv.foodrecipesapp.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stv.foodrecipesapp.R
import de.hdodenhof.circleimageview.CircleImageView

class CategoryViewHolder(
    itemView: View,
    listener: OnRecipeListener
) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    var imageView: CircleImageView = itemView.findViewById(R.id.category_image)
    var titleView: TextView = itemView.findViewById(R.id.category_title)
    var mOnRecipeListener: OnRecipeListener = listener

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        mOnRecipeListener.onCategoryClick(titleView.text.toString())
    }
}
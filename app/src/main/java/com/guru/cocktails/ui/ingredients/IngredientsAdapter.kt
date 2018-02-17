package com.guru.cocktails.ui.ingredients

import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.cocktailsguru.android.platform.extensions.notifyNewData
import com.guru.cocktails.R
import com.guru.cocktails.domain.model.IngredientThumb
import com.guru.cocktails.platform.extensions.inflate
import kotlinx.android.synthetic.main.item_coctail_grid.view.*
import kotlin.properties.Delegates


class IngredientsAdapter(val callbacks: Callbacks) : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    private var items: List<IngredientThumb> by Delegates.observable(emptyList()) { prop, old, new ->
        notifyNewData(old, new) { o, n -> o == n }
    }

    interface Callbacks {
        fun onClick(item: IngredientThumb, sharedElements: List<Pair<View, String>>?)
    }

    fun updateData(newData: List<IngredientThumb>) {
        items = newData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = parent.inflate(R.layout.item_coctail_grid)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(item: IngredientThumb) {

            with(itemView) {
                text_line_1.text = item.imageName
             //   val pairs = listOf(Pair(image as View, "image"))
                setOnClickListener { callbacks.onClick(item, null) }
            }
        }
    }
}
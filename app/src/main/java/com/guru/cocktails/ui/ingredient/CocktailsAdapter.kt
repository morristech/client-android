package com.guru.cocktails.ui.ingredient

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.cocktailsguru.android.platform.extensions.notifyNewData
import com.guru.cocktails.R
import com.guru.cocktails.platform.extensions.inflate
import com.guru.cocktails.ui.cocktails.CocktailViewModel
import kotlin.properties.Delegates


class CocktailsAdapter(/*val callbacks: Callbacks*/) : RecyclerView.Adapter<CocktailsAdapter.ViewHolder>() {

    private var items: List<CocktailViewModel> by Delegates.observable(emptyList()) { prop, old, new ->
        notifyNewData(old, new) { o, n -> o.name == n.name }
    }

    interface Callbacks {
        fun onClick(item: CocktailViewModel)
    }

    fun updateData(newData: List<CocktailViewModel>) {
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

        fun bindView(item: CocktailViewModel) {

            with(itemView) {

            }
        }

    }

}
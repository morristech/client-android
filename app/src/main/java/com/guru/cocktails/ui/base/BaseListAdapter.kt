package com.guru.cocktails.ui.base

import android.support.v4.util.Pair
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.guru.cocktails.R
import com.guru.cocktails.domain.model.base.BaseListItem
import com.guru.cocktails.platform.extensions.inflate
import com.guru.cocktails.platform.extensions.notifyNewData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coctail_grid.view.*
import kotlin.properties.Delegates

abstract class BaseListAdapter<ListItem : BaseListItem>(
    val callbacks: Callbacks<ListItem>,
    val picasso: Picasso
) : RecyclerView.Adapter<BaseListAdapter<ListItem>.ViewHolder>() {

    private var items: List<ListItem> by Delegates.observable(emptyList()) { _, old, new ->
        notifyNewData(old, new) { o, n -> o == n }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(getListItemLayout()))

    open fun getListItemLayout() = R.layout.base__thumb_item

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindView(items[position])

    override fun getItemCount() = items.size

    fun updateData(newData: List<ListItem>) {
        items = newData
    }

    interface Callbacks<in ListItem : BaseListItem> {
        fun onClick(item: ListItem, sharedElements: List<Pair<View, String>>?)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(item: ListItem) {

            with(itemView) {
                titleName.text = item.name
                picasso.load(item.imageUrl).into(image)
                //   val pairs = listOf(Pair(image as View, "image"))
                setOnClickListener { callbacks.onClick(item, null) }
            }
        }
    }
}
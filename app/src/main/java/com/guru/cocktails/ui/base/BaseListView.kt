package com.guru.cocktails.ui.base

import com.guru.cocktails.domain.model.base.BaseListItem

interface BaseListView<in ListItem : BaseListItem> {
    fun startLoading()
    fun stopLoading()
    fun onNewData(list: List<ListItem>)
    fun onError(error: Throwable)
}
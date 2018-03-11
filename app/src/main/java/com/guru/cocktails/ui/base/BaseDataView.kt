package com.guru.cocktails.ui.base

interface BaseDataView<T> {
    fun startLoading()
    fun stopLoading()
    fun onNewData(item: T)
    fun onError(error: Throwable)
}
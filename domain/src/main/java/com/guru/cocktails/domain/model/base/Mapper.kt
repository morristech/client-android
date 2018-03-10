package com.guru.cocktails.domain.model.base

import java.util.*

abstract class Mapper<To, From> {

    abstract fun map(from: From): To

    abstract fun reverse(to: To): From

    fun map(list: List<From>?): List<To> {
        if (list != null) {
            val result = ArrayList<To>(list.size)
            list.mapTo(result) { map(it) }
            return result
        }
        return emptyList()
    }

    fun reverse(list: List<To>?): List<From> {
        if (list != null) {
            val result = ArrayList<From>(list.size)
            list.mapTo(result) { reverse(it) }
            return result
        }
        return emptyList()
    }

    companion object {
        const val INVALID_INT = -1
        const val INVALID_LONG = -1L
        const val INVALID_DOUBLE = -1.0
        const val EMPTY_STRING = ""
    }
}

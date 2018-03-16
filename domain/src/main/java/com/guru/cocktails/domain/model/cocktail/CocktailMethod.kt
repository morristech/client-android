package com.guru.cocktails.domain.model.cocktail

import com.guru.cocktails.domain.model.base.Mapper


data class CocktailMethod(
    val id: Int,
    val name: String,
    val description: String
) {
    companion object {
        val EMPTY = CocktailMethod(Mapper.INVALID_INT, Mapper.EMPTY_STRING, Mapper.EMPTY_STRING)
    }
}
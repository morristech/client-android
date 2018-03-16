package com.guru.cocktails.domain.model.cocktail

import com.guru.cocktails.domain.model.base.Mapper


data class CocktailGlass(
    val id: Int,
    val name: String
) {
    companion object {
        val EMPTY = CocktailGlass(Mapper.INVALID_INT, Mapper.EMPTY_STRING)
    }
}
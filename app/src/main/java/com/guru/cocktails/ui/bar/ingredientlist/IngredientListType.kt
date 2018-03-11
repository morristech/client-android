package com.guru.cocktails.ui.bar.ingredientlist

sealed class IngredientListType {
    class Alcoholic : IngredientListType()
    class NonAlcoholic : IngredientListType()
}
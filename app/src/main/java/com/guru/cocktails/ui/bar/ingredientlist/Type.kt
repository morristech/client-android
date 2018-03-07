package com.guru.cocktails.ui.bar.ingredientlist

sealed class Type {
    class Alcoholic : Type()
    class NonAlcoholic : Type()
}
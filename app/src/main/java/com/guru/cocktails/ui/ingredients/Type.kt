package com.guru.cocktails.ui.ingredients

sealed class Type {
    class Alcoholic : Type()
    class NonAlcoholic : Type()
}
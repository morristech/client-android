package com.guru.cocktails.ui.bar.ingredients

sealed class Type {
    class Alcoholic : Type()
    class NonAlcoholic : Type()
}
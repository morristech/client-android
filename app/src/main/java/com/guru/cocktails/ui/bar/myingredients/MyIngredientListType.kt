package com.guru.cocktails.ui.bar.myingredients

sealed class MyIngredientListType {
    class MyBar : MyIngredientListType()
    class ShoppingList : MyIngredientListType()
}
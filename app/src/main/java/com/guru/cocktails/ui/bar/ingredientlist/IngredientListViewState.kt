package com.guru.cocktails.ui.bar.ingredientlist

import com.guru.cocktails.domain.model.ingredient.IngredientThumb

sealed class IngredientListViewState {
    class Init : IngredientListViewState()
    class Loading : IngredientListViewState()
    class Success(val item: List<IngredientThumb>) : IngredientListViewState()
    class LoadingFinished : IngredientListViewState()
    class Error(val error: Throwable) : IngredientListViewState()
}
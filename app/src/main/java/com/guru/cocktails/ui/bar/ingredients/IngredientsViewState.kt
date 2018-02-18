package com.guru.cocktails.ui.bar.ingredients

import com.guru.cocktails.domain.model.ingredient.IngredientThumb

sealed class IngredientsViewState {
    class Init : IngredientsViewState()
    class Loading : IngredientsViewState()
    class Success(val item: List<IngredientThumb>) : IngredientsViewState()
    class LoadingFinished : IngredientsViewState()
    class Error(val error: Throwable) : IngredientsViewState()
}
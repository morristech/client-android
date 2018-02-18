package com.guru.cocktails.ui.ingredient

import com.guru.cocktails.domain.model.ingredient.IngredientDetail

sealed class IngredientViewState {
    class Init : IngredientViewState()
    class Loading : IngredientViewState()
    class Success(val item: IngredientDetail) : IngredientViewState()
    class LoadingFinished : IngredientViewState()
    class Error(val error: Throwable) : IngredientViewState()
}
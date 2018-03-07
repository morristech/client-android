package com.guru.cocktails.ui.ingredientdetail

import com.guru.cocktails.domain.model.ingredient.IngredientDetail

sealed class IngredientDetailViewState {
    class Init : IngredientDetailViewState()
    class Loading : IngredientDetailViewState()
    class Success(val item: IngredientDetail) : IngredientDetailViewState()
    class LoadingFinished : IngredientDetailViewState()
    class Error(val error: Throwable) : IngredientDetailViewState()
}
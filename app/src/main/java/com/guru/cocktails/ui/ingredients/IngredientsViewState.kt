package com.guru.cocktails.ui.ingredients

import com.guru.cocktails.domain.model.IngredientThumb
import com.guru.cocktails.domain.model.ListBundle

sealed class IngredientsViewState {
    class Init : IngredientsViewState()
    class Loading : IngredientsViewState()
    class Success(val item: ListBundle<IngredientThumb>) : IngredientsViewState()
    class LoadingFinished : IngredientsViewState()
    class Error(val error: Throwable) : IngredientsViewState()
}
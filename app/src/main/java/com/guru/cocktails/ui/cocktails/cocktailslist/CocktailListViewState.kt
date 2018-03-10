package com.guru.cocktails.ui.cocktails.cocktailslist

import com.guru.cocktails.domain.model.cocktail.CocktailThumb

sealed class CocktailListViewState {
    class Init : CocktailListViewState()
    class Loading : CocktailListViewState()
    class Success(val item: List<CocktailThumb>) : CocktailListViewState()
    class LoadingFinished : CocktailListViewState()
    class Error(val error: Throwable) : CocktailListViewState()
}
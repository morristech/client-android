package com.guru.cocktails.ui.cocktails.cocktailslist

import com.guru.cocktails.domain.model.cocktail.CocktailThumb
import com.guru.cocktails.ui.base.BaseListAdapter
import com.squareup.picasso.Picasso

class CocktailListAdapter(
    callbacks: Callbacks<CocktailThumb>,
    picasso: Picasso
) : BaseListAdapter<CocktailThumb>(callbacks, picasso)
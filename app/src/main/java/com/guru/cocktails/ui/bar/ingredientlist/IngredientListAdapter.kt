package com.guru.cocktails.ui.bar.ingredientlist

import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.ui.base.BaseListAdapter
import com.squareup.picasso.Picasso


class IngredientListAdapter(callbacks: Callbacks<IngredientThumb>, picasso: Picasso) :
        BaseListAdapter<IngredientThumb>(callbacks, picasso)
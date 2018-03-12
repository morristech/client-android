package com.guru.cocktails.ui.bar.myingredients

import com.guru.cocktails.domain.model.ingredient.MyIngredient
import com.guru.cocktails.ui.base.BaseListAdapter
import com.squareup.picasso.Picasso

class MyIngredientListAdapter(
    callbacks: Callbacks<MyIngredient>,
    picasso: Picasso
) : BaseListAdapter<MyIngredient>(callbacks, picasso)
package com.guru.cocktails.domain.repository

import com.guru.cocktails.domain.model.IngredientThumb
import com.guru.cocktails.domain.model.ListBundle
import io.reactivex.Flowable

interface IngredientsRepository {
    fun getNonAlcoList(): Flowable<ListBundle<IngredientThumb>>
}

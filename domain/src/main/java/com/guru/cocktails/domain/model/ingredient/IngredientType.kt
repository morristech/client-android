package com.guru.cocktails.domain.model.ingredient

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IngredientType(
    val id: Int,
    val name: String
) : Parcelable
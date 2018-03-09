package com.guru.cocktails.domain.model.ingredient

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IngredientDetail(
    val id: Int,
    val name: String,
    val nameGrouped: String,
    val description: String,
    val imageName: String,
    val imageUrl: String,
    val numShowed: Int,
    val ingredientType: IngredientType,
    val voltage: Double
) : Parcelable
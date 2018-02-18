package com.guru.cocktails.ui.description

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DescriptionViewModel(
    val title: String,
    val desctiption: String,
    val imageUrl: String
) : Parcelable
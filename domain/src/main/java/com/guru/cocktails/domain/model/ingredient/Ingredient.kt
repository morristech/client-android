package com.guru.cocktails.domain.model.ingredient


data class Ingredient(
    val id: Int,
    val name: String,
    val nameGrouped: String,
    val nameModif: String,
    val volume: String,
    val units: String,
    val voltage: Double,
    val desc: String,
    val preparation: String,
    val imgFileName: String,
    val videoURL: String?,
    val websiteURL: String?,
    val tasteID: Long?,
    val numShowed: Long,
    val categoryID: Int,
    val dataCol: String?,
    val numKcal: Long,
    val flags: String
)

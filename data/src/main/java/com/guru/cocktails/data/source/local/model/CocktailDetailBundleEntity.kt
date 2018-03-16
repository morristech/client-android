package com.guru.cocktails.data.source.local.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

class CocktailDetailBundleEntity {
    @Embedded
    var cocktail: CocktailDetailEntity? = null

    @Relation(parentColumn = "glassId", entityColumn = "id", entity = CocktailGlassEntity::class)
    var glass: List<CocktailGlassEntity> = emptyList()

    @Relation(parentColumn = "methodId", entityColumn = "id", entity = CocktailMethodEntity::class)
    var method: List<CocktailMethodEntity> = emptyList()
}



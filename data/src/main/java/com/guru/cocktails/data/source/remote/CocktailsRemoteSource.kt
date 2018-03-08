package com.guru.cocktails.data.source.remote


import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientDetailDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientThumbDto
import com.guru.cocktails.domain.model.ListBundle
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailsRemoteSource
@Inject
constructor(retrofit: Retrofit) : RemoteSource {

    private val client: CocktailsApiClient = retrofit.create(CocktailsApiClient::class.java)

    override fun getIngredientList(): Single<ListBundle<IngredientThumbDto>> {
        return client.getIngredientList(0,1000)
    }

    override fun getIngredientDetail(ingredientId: Int): Single<IngredientDetailDto> {
        return client.getIngredientDetail(ingredientId)
    }
}

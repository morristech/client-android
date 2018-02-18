package com.guru.cocktails.data.source.remote


import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientDetailDto
import com.guru.cocktails.data.source.remote.model.ingredient.IngredientThumbDto
import com.guru.cocktails.domain.model.ListBundle
import com.guru.cocktails.domain.model.ReqBody
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CocktailsRemoteSource
@Inject
constructor(retrofit: Retrofit) : RemoteSource {

    private val client: CocktailsApiClient = retrofit.create(CocktailsApiClient::class.java)


    override fun getAllAlcoholicIngredients(): Single<ListBundle<IngredientThumbDto>> {
        return client.getAllAlcoholicIngredients(ReqBody(1000))
    }

    override fun getAllNonAlcoholicIngredients(): Single<ListBundle<IngredientThumbDto>> {
        return client.getAllNonAlcoholicIngredients(ReqBody(1000))
    }

    override fun getIngredientDetail(ingredientId: Int): Single<IngredientDetailDto> {
        return client.getIngredientDetail(ingredientId)
    }
}

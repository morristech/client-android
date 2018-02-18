package com.guru.cocktails.data.source.remote


import com.guru.cocktails.data.source.RemoteSource
import com.guru.cocktails.data.source.remote.model.WeatherDto
import com.guru.cocktails.domain.model.ingredient.IngredientThumb
import com.guru.cocktails.domain.model.ListBundle
import com.guru.cocktails.domain.model.ReqBody
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRemoteSource
@Inject
constructor(retrofit: Retrofit) : RemoteSource {

    private val client: CgApiClient = retrofit.create(CgApiClient::class.java)

    override fun getWeatherForCity(city: String): Single<WeatherDto> {
        return client.getWeatherForCity(city)
    }

    override fun getNonAlcoList(): Single<ListBundle<IngredientThumb>> {
        return client.getNonAlcoList(ReqBody(1000))
    }
}

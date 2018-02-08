package com.guru.cocktails.di.module

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.GetWeatherRemotelyUseCase
import com.guru.cocktails.domain.interactor.definition.GetWeatherUseCase
import com.guru.cocktails.platform.bus.data.DataBus
import com.guru.cocktails.platform.bus.event.EventBus
import com.guru.cocktails.ui._remove.example1.fragment.Example1Contract
import com.guru.cocktails.ui._remove.example1.fragment.Example1Presenter
import com.guru.cocktails.ui._remove.example2.Example2Contract
import com.guru.cocktails.ui._remove.example2.Example2Presenter
import com.guru.cocktails.ui._remove.example3.fragment.Example3Contract
import com.guru.cocktails.ui._remove.example3.fragment.Example3Presenter
import com.guru.cocktails.ui.ingredient.IngredientContract
import com.guru.cocktails.ui.ingredient.IngredientPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @ViewScope
    @Provides
    internal fun example1Presenter(getWeatherUseCase: GetWeatherUseCase): Example1Contract.Presenter {
        return Example1Presenter(getWeatherUseCase)
    }

    @ViewScope
    @Provides
    internal fun example2Presenter(remotelyUseCaseGet: GetWeatherRemotelyUseCase): Example2Contract.Presenter {
        return Example2Presenter(remotelyUseCaseGet)
    }

    @ViewScope
    @Provides
    internal fun example3Presenter(remotelyUseCaseGet: GetWeatherRemotelyUseCase, dataBus: DataBus, eventBus: EventBus): Example3Contract.Presenter {
        return Example3Presenter(remotelyUseCaseGet, dataBus, eventBus)
    }

    @ViewScope
    @Provides
    internal fun ingredientPresenter(): IngredientContract.Presenter {
        return IngredientPresenter()
    }
}

package com.guru.cocktails.di.module

import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.domain.interactor.definition.GetWeatherRemotelyUseCase
import com.guru.cocktails.ui._remove.example2.Example2Contract
import com.guru.cocktails.ui._remove.example2.Example2Presenter
import dagger.Module
import dagger.Provides

@Module
class PresenterMockModule {

    @ViewScope
    @Provides
    internal fun example2Presenter(remotelyUseCaseGet: GetWeatherRemotelyUseCase): Example2Contract.Presenter {
        return Example2Presenter(remotelyUseCaseGet)
    }

}
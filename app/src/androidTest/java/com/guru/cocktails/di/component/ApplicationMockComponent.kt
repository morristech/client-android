package com.guru.cocktails.di.component

import com.guru.cocktails.di.module.ApplicationMockModule
import com.guru.cocktails.di.module.InteractorMockModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        ApplicationMockModule::class,
        InteractorMockModule::class
    )
)
interface ApplicationMockComponent : ApplicationComponent {

}
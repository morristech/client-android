package com.guru.cocktails.di.component

import com.guru.cocktails.di.module.PresenterMockModule
import com.guru.cocktails.di.scope.ViewScope
import com.guru.cocktails.ui._remove.example2.Example2ActivityTest
import com.guru.cocktails.ui._remove.example2.Example2PresenterTest
import dagger.Component

@ViewScope
@Component(
    dependencies = arrayOf(
        ApplicationMockComponent::class
    ),
    modules = arrayOf(PresenterMockModule::class)
)
interface ViewMockComponent {

    fun inject(item: Example2ActivityTest)
    fun inject(item: Example2PresenterTest)
}
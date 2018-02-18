package com.guru.cocktails.di.component

import android.content.Context
import com.guru.cocktails.di.module.*
import com.guru.cocktails.domain.executor.SchedulerProvider
import com.guru.cocktails.domain.interactor.definition.IngredientsUseCase
import com.guru.cocktails.platform.analytics.AnalyticsManager
import com.guru.cocktails.platform.bus.data.DataBus
import com.guru.cocktails.platform.bus.event.EventBus
import com.guru.cocktails.platform.navigation.Navigator
import com.guru.cocktails.ui.base.BaseActivity
import com.guru.cocktails.ui.base.BaseFragment
import com.guru.cocktails.ui.description.DescriptionActivity
import com.guru.cocktails.ui.shared.DrawerManager
import com.squareup.picasso.Picasso
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        DataModule::class,
        MapperModule::class,
        NetworkModule::class,
        InteractorModule::class,
        ApplicationModule::class
    )
)
interface ApplicationComponent {

    fun inject(item: BaseActivity)
    fun inject(item: BaseFragment)
    fun inject(item: DrawerManager)
    fun inject(item: DescriptionActivity)

    /* exposing to other components [com.guru.cocktails.di.component.ViewComponent] */
    fun context(): Context

    fun scheduler(): SchedulerProvider
    fun navigator(): Navigator
    fun eventBus(): EventBus
    fun picasso(): Picasso
    fun dataBus(): DataBus
    fun analyticsManager(): AnalyticsManager
    fun ingredientsUseCase(): IngredientsUseCase
}

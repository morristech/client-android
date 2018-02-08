package com.guru.cocktails.di.module

import android.content.Context
import com.mixpanel.android.mpmetrics.MixpanelAPI
import com.guru.cocktails.R
import com.guru.cocktails.domain.executor.SchedulerProvider
import com.guru.cocktails.domain.executor.SchedulerProviderImpl
import com.guru.cocktails.platform.analytics.AnalyticsManager
import com.guru.cocktails.platform.analytics.AnalyticsManagerImpl
import com.guru.cocktails.platform.analytics.MixpanelAnalyticsManager
import com.guru.cocktails.platform.bus.data.DataBus
import com.guru.cocktails.platform.bus.event.EventBus
import com.guru.cocktails.platform.navigation.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val context: Context) {

    @Singleton
    @Provides
    internal fun context(): Context {
        return context
    }

    @Singleton
    @Provides
    internal fun eventBus(): EventBus {
        return EventBus()
    }

    @Singleton
    @Provides
    internal fun dataBus(): DataBus {
        return DataBus()
    }

    @Singleton
    @Provides
    internal fun schedulerProvider(): SchedulerProvider {
        return SchedulerProviderImpl()
    }

    @Singleton
    @Provides
    internal fun navigator(): Navigator {
        return Navigator()
    }

    @Singleton
    @Provides
    internal fun provideAnalyticsManager(context: Context): AnalyticsManager {
        val mixPanel = MixpanelAnalyticsManager(MixpanelAPI.getInstance(context, context.getString(R.string.mixpanel_key)))
        return AnalyticsManagerImpl(listOf(mixPanel))
    }

}

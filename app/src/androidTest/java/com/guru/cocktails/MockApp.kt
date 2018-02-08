package com.guru.cocktails

import com.guru.cocktails.di.component.ApplicationComponent
import com.guru.cocktails.di.component.DaggerApplicationMockComponent
import com.guru.cocktails.di.module.ApplicationMockModule
import com.guru.cocktails.di.module.InteractorMockModule

class MockApp : App() {

    override fun initializeAppComponent(): ApplicationComponent {
        return DaggerApplicationMockComponent.builder()
            .applicationMockModule(ApplicationMockModule(this))
            .interactorMockModule(InteractorMockModule())
            .build()
    }
}

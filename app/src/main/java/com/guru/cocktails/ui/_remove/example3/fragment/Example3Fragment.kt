package com.guru.cocktails.ui._remove.example3.fragment

import android.os.Bundle
import android.view.View
import com.guru.cocktails.App
import com.guru.cocktails.R
import com.guru.cocktails.di.component.DaggerViewComponent
import com.guru.cocktails.di.module.PresenterModule
import com.guru.cocktails.domain.model.Weather
import com.guru.cocktails.ui.base.BaseFragment
import com.guru.cocktails.ui._remove.example3.fragment.Example3Contract.Presenter
import kotlinx.android.synthetic.main.fragment_weather.*
import javax.inject.Inject


class Example3Fragment : BaseFragment(), Example3Contract.View {

    private var presenter: Presenter? = null

    override fun layoutId() = R.layout.fragment_weather

    override fun initializeDependencies() {
        DaggerViewComponent.builder()
            .applicationComponent(App.instance.appComponent())
            .presenterModule(PresenterModule())
            .build().inject(this)
    }

    @Inject
    override fun attachPresenter(presenter: Presenter) {
        this.presenter = presenter
        this.presenter?.attachView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.start()
        btn_refresh.setOnClickListener { presenter?.refresh() }
    }

    override fun onDestroy() {
        presenter?.stop()
        super.onDestroy()
    }

    override fun showWeather(data: Weather) {
        tv_city.text = data.name
        tv_visibility.text = data.visibility.toString()
    }

    companion object {
        fun newInstance(): Example3Fragment {
            return Example3Fragment()
        }
    }
}

package com.guru.cocktails.domain.interactor.base

import com.guru.cocktails.domain.executor.SchedulerProvider
import io.reactivex.Single

abstract class SingleInteractor<T, Parameters>(
    private val schedulerProvider: SchedulerProvider
) : BaseInteractor<T>() {

    abstract fun buildUseCase(parameters: Parameters): Single<T>

    fun execute(onNext: (T) -> Unit, onError: (Throwable) -> Unit = {}, params: Parameters) {
        val single = buildUseCase(params).subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
        val disposable = single.subscribeWith(getDisposableSingleObserver(onNext, onError))
        disposables.add(disposable)
    }

}

package com.guru.cocktails.ui.shared

import com.guru.cocktails.domain.model.Weather


sealed class ViewState {
    class Init : ViewState()
    class Loading : ViewState()
    class Success(val item: Weather) : ViewState()
    class LoadingFinished : ViewState()
    class Error(val error: Throwable) : ViewState()
}
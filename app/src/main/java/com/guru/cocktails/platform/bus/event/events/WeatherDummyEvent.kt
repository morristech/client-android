package com.guru.cocktails.platform.bus.event.events

import com.guru.cocktails.domain.model.Weather
import com.guru.cocktails.platform.bus.event.BaseEventBus

class WeatherDummyEvent : BaseEventBus<Weather>() {

    companion object {
        val ACTION_HELLO = "ACTION_HELLO"
    }
}
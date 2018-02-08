package com.guru.cocktails.platform.bus.event

import com.guru.cocktails.platform.bus.event.events.FragmentSyncEvent
import com.guru.cocktails.platform.bus.event.events.WeatherDummyEvent


class EventBus {
    val fragmentSyncEvent = FragmentSyncEvent()
    val weatherDummyEvent = WeatherDummyEvent()
}
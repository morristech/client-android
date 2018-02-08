package com.guru.cocktails.platform.bus.event

import com.guru.cocktails.platform.bus.BaseBus
import com.guru.cocktails.platform.bus.event.events.BaseEvent


open class BaseEventBus<T> : BaseBus<BaseEvent<T>>()
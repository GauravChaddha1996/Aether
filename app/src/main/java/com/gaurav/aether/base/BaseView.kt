package com.gaurav.aether.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent

interface BaseView<in T> : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun attachView()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun detachView()

    fun render(state: T)
}
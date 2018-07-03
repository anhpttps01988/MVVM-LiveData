package com.example.anhptt.firststepmvvm.common.viewmodel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun create() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun start() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun stop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    open fun pause() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun resume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    open fun destroy() {

    }

}
package com.example.anhptt.firststepmvvm.common.viewmodel

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ViewModel

open class BaseViewModel : ViewModel(), LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    open fun start(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    open fun stop(){

    }

}
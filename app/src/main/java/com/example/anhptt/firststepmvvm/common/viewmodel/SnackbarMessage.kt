package com.example.anhptt.firststepmvvm.common.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.annotation.StringRes


class SnackbarMessage : SingleLiveEvent<Int>() {

    fun observe(owner: LifecycleOwner, observer: SnackbarObserver) {
        super.observe(owner, Observer {
            if (it != null) {
                observer.onNextMessage(it)
            }
        })
    }

    interface SnackbarObserver {
        fun onNextMessage(@StringRes snackbarMessage: Int)
    }

}
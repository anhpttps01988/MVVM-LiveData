package com.example.anhptt.firststepmvvm.activities.detail.viewmodel

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.ViewModel
import com.example.anhptt.firststepmvvm.common.viewmodel.BaseViewModel
import com.example.anhptt.firststepmvvm.data.source.DataRepository
import javax.inject.Inject

class DetailActivityViewModel @Inject constructor(private var dataRepository: DataRepository) : BaseViewModel(), LifecycleObserver, DetailActivityViewModelContract.ViewModelContract {


    override fun start() {
        super.start()
    }


    override fun stop() {
        super.stop()
    }


}
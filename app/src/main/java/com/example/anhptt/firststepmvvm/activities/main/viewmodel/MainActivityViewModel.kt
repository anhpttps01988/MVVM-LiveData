package com.example.anhptt.firststepmvvm.activities.main.viewmodel

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.anhptt.firststepmvvm.SingleLiveEvent
import com.example.anhptt.firststepmvvm.common.viewmodel.BaseViewModel
import com.example.anhptt.firststepmvvm.data.source.DataRepository
import com.example.anhptt.firststepmvvm.extensions.groupThounsandsToString
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private var dataRepository: DataRepository) : BaseViewModel(), LifecycleObserver, MainActivityContract.ViewModelContract {

    var name = MutableLiveData<String>()
    var goToDetail = SingleLiveEvent<Void>()
    private var compositeDisposable = CompositeDisposable()

    companion object {
        const val TAG = "MainActivityViewModel"
    }
    override fun start() {
        super.start()
    }

    override fun stop() {
        super.stop()
        compositeDisposable.clear()
    }

    override fun navigatorDetail() {
        goToDetail.call()
    }

    override fun displayName(): MutableLiveData<String> {
        name.value = "ABC"
        return name
    }

    override fun onCleared() {
        super.onCleared()
    }
}
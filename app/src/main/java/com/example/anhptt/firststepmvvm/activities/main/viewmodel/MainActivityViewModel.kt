package com.example.anhptt.firststepmvvm.activities.main.viewmodel

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.anhptt.firststepmvvm.common.viewmodel.SingleLiveEvent
import com.example.anhptt.firststepmvvm.common.viewmodel.BaseViewModel
import com.example.anhptt.firststepmvvm.data.source.DataRepository
import com.example.anhptt.firststepmvvm.data.source.response.Book
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Response
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(private var dataRepository: DataRepository) : BaseViewModel(), LifecycleObserver, MainActivityContract.ViewModelContract {


    var name = MutableLiveData<String>()
    var goToDetail = SingleLiveEvent<Void>()
    var bookDataList = MutableLiveData<List<Book>>()
    var isLoadingData = MutableLiveData<Boolean>()
    var isRefreshingData = MutableLiveData<Boolean>()

    private var compositeDisposable = CompositeDisposable()

    companion object {
        const val TAG = "MainActivityViewModel"
    }

    override fun start() {
        super.start()
        isLoadingData.postValue(false)
    }

    override fun stop() {
        super.stop()
        compositeDisposable.clear()
    }

    override fun loadBookData() {
        isLoadingData.postValue(true)
        isRefreshingData.postValue(false)
        compositeDisposable.add(dataRepository.getBooks().flatMap { t: Response<List<Book>> ->
            (if (t.isSuccessful) {
                Observable.just(t.body())
            } else
                Observable.error(Exception(t.errorBody().toString())))
        }.subscribe(
                this::onBookListResponse,
                this::onBookListError
        ))
    }

    private fun onBookListResponse(response: List<Book>?) {
        isLoadingData.postValue(false)
        if (response != null) {
            Log.d(TAG, "size = ${response.size}")
            for (i in response) {
                bookDataList.postValue(response)
            }
        }
    }

    override fun refreshBookData(isRefresh: Boolean?) {
        if (isRefresh!!) {
            loadBookData()
        }
    }

    override fun testDoSomething(): String = "Dagger UnitTest"


    private fun onBookListError(throws: Throwable) {
        isLoadingData.postValue(false)
        Log.d(TAG, "${throws.message}")
    }

    override fun navigatorDetail() {
        goToDetail.call()
    }

    override fun displayName(): MutableLiveData<String> {
        name.value = "Android MVVM Pattern"
        return name
    }

    override fun onCleared() {
        super.onCleared()
    }
}
package com.example.anhptt.firststepmvvm.activities.detail.viewmodel

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.anhptt.firststepmvvm.common.viewmodel.BaseViewModel
import com.example.anhptt.firststepmvvm.common.viewmodel.SnackbarMessage
import com.example.anhptt.firststepmvvm.data.source.DataRepository
import com.example.anhptt.firststepmvvm.data.source.local.dao.DataSample
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailActivityViewModel @Inject constructor(private var dataRepository: DataRepository) : BaseViewModel(), LifecycleObserver, DetailActivityViewModelContract.ViewModelContract {

    var editFirstName = MutableLiveData<String>()
    var editLastName = MutableLiveData<String>()
    var listDataSample = MutableLiveData<List<DataSample>>()
    var dataSample = MutableLiveData<DataSample>()
    var isRefreshingData = MutableLiveData<Boolean>()
    val snackbarMessage = SnackbarMessage()
    private val compositeDisposable = CompositeDisposable()

    companion object {
        val TAG = "DetailActivityViewModel"
    }

    override fun start() {
        super.start()
        onLoadData()
    }

    override fun stop() {
        super.stop()
        compositeDisposable.clear()
    }

    override fun onRefreshData(isRefreshing: Boolean?) {
        isRefreshingData.postValue(true)
        if (isRefreshing!!){
            onLoadData()
        }
    }

    override fun onSubmitData() {
        if (editFirstName.value != null && editLastName.value != null) {
            dataRepository.insertDataSample(DataSample(editFirstName.value, editLastName.value))
            onLoadData()
        } else {

        }
    }

    override fun onUpdateData() {
        if (editFirstName.value != null && editLastName.value != null) {
            dataSample.value!!.first_name = editFirstName.value
            dataSample.value!!.last_name = editLastName.value
            dataRepository.updateDataSample(dataSample = dataSample.value!!)
        } else {

        }
    }

    override fun onLoadData() {
        compositeDisposable.add(dataRepository.getDataSample()
                .subscribe(this::onDataSampleSuccess,
                        this::onDataSampleError))
    }

    private fun onDataSampleSuccess(listSample: List<DataSample>) {
        isRefreshingData.postValue(false)
        if (listSample.isNotEmpty()) {
            listDataSample.postValue(listSample)
            Log.d(TAG, "Data size ${listSample.size}")
        }
    }

    private fun onDataSampleError(throwable: Throwable) {
        isRefreshingData.postValue(false)
        Log.d(TAG, throwable.message)
    }
}
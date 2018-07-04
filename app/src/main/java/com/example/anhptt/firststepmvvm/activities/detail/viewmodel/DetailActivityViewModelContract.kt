package com.example.anhptt.firststepmvvm.activities.detail.viewmodel

import com.example.anhptt.firststepmvvm.data.source.local.dao.DataSample


interface DetailActivityViewModelContract {

    interface ViewModelContract {
        fun onSubmitData()
        fun onUpdateData()
        fun onDeleteData(dataSample: DataSample)
        fun onLoadData()
        fun onRefreshData(isRefreshing: Boolean?)
        fun onBindingDataToField(dataSample: DataSample)
    }

    interface Navigator {

    }

}
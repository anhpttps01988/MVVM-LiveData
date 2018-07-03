package com.example.anhptt.firststepmvvm.activities.detail.viewmodel


interface DetailActivityViewModelContract {

    interface ViewModelContract {
        fun onSubmitData()
        fun onUpdateData()
        fun onLoadData()
        fun onRefreshData(isRefreshing: Boolean?)
    }

    interface Navigator {

    }

}
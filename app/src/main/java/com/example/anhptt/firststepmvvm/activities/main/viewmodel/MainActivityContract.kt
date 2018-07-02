package com.example.anhptt.firststepmvvm.activities.main.viewmodel

import android.arch.lifecycle.MutableLiveData

interface MainActivityContract {

    interface ViewModelContract{
        fun displayName() : MutableLiveData<String>
        fun navigatorDetail()
        fun loadBookData()
    }

    interface Navigator {
        fun goToDetail()
    }

}
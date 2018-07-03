package com.example.anhptt.firststepmvvm.common.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.anhptt.firststepmvvm.common.viewmodel.ViewModelFactory
import com.example.anhptt.firststepmvvm.activities.detail.viewmodel.DetailActivityViewModel
import com.example.anhptt.firststepmvvm.activities.main.viewmodel.MainActivityViewModel
import com.example.anhptt.firststepmvvm.common.di.scopes.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun mainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailActivityViewModel::class)
    abstract fun detailActivityViewModel(detailActivityViewModel: DetailActivityViewModel): ViewModel


    @Binds
    abstract fun viewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory


}
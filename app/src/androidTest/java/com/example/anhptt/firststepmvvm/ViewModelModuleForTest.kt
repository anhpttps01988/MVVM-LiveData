package com.example.anhptt.firststepmvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.anhptt.firststepmvvm.activities.detail.viewmodel.DetailActivityViewModel
import com.example.anhptt.firststepmvvm.activities.main.viewmodel.MainActivityViewModel
import com.example.anhptt.firststepmvvm.common.di.ViewModelModule
import com.example.anhptt.firststepmvvm.common.di.scopes.ViewModelKey
import com.example.anhptt.firststepmvvm.common.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import org.mockito.Mockito

@Module
abstract class ViewModelModuleForTest : ViewModelModule() {


}



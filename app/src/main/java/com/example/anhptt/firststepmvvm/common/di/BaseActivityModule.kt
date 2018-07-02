package com.example.anhptt.firststepmvvm.common.di

import com.example.anhptt.firststepmvvm.common.di.scopes.PerActivity
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class BaseActivityModule {

    @PerActivity
    @Provides
    fun compositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

}
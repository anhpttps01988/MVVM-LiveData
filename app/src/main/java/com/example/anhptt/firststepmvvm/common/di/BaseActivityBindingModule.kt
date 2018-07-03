package com.example.anhptt.firststepmvvm.common.di

import com.example.anhptt.firststepmvvm.activities.detail.view.DetailActivity
import com.example.anhptt.firststepmvvm.activities.detail.di.DetailActivityModule
import com.example.anhptt.firststepmvvm.activities.main.di.MainActivityModule
import com.example.anhptt.firststepmvvm.activities.main.view.MainActivity
import com.example.anhptt.firststepmvvm.common.di.scopes.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class BaseActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [BaseActivityModule::class, MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [BaseActivityModule::class, DetailActivityModule::class])
    abstract fun detailActivity(): DetailActivity
}
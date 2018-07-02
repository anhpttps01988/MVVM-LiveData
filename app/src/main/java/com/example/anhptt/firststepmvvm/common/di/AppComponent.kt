package com.example.anhptt.firststepmvvm.common.di

import com.example.anhptt.firststepmvvm.App
import com.example.anhptt.firststepmvvm.data.source.DataRepository
import com.example.anhptt.firststepmvvm.data.source.di.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, AndroidSupportInjectionModule::class, BaseActivityBindingModule::class, RepositoryModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun dataRepository(): DataRepository
    fun inject(app: App)

    override fun inject(instance: DaggerApplication?) {
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

}
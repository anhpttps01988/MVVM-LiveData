package com.example.anhptt.firststepmvvm.common.di

import android.app.Application
import com.example.anhptt.firststepmvvm.App
import com.example.anhptt.firststepmvvm.data.source.DataRepository
import com.example.anhptt.firststepmvvm.data.source.di.RepositoryModule
import com.example.anhptt.firststepmvvm.data.source.local.dao.di.RoomModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
        modules =
        [
            AppModule::class,
            RepositoryModule::class,
            NetModule::class,
            RoomModule::class,
            AndroidSupportInjectionModule::class,
            BaseActivityBindingModule::class
        ])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: App)

    override fun inject(instance: DaggerApplication?) {
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}
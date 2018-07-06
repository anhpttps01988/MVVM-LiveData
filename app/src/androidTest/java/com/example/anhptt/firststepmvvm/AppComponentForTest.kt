package com.example.anhptt.firststepmvvm

import android.app.Application
import com.example.anhptt.firststepmvvm.common.di.AppComponent
import com.example.anhptt.firststepmvvm.main.MainActivityViewModelTest
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules =
[
    ViewModelModuleForTest::class,
    AndroidSupportInjectionModule::class,
    RepositoryModuleTest::class,
    BaseActivityBindingModuleForTest::class,
    NetModuleForTest::class,
    RoomModuleForTest::class
])
interface AppComponentForTest : AppComponent {
    fun inject(mainActivityViewModelTest: MainActivityViewModelTest)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponentForTest
    }
}
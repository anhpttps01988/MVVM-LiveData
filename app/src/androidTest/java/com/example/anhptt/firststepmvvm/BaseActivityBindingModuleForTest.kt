package com.example.anhptt.firststepmvvm

import com.example.anhptt.firststepmvvm.activities.detail.view.DetailActivity
import com.example.anhptt.firststepmvvm.activities.main.view.MainActivity
import com.example.anhptt.firststepmvvm.common.di.BaseActivityBindingModule
import dagger.Module
import org.mockito.Mockito

@Module
abstract class BaseActivityBindingModuleForTest : BaseActivityBindingModule() {

    override fun mainActivity(): MainActivity {
        return Mockito.mock(MainActivity::class.java)
    }

    override fun detailActivity(): DetailActivity {
        return Mockito.mock(DetailActivity::class.java)
    }
}
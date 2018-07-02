package com.example.anhptt.firststepmvvm.common.activity

import android.app.Activity
import android.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


open class BaseActivity : AppCompatActivity(), HasActivityInjector, HasFragmentInjector, HasSupportFragmentInjector {


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var dispatchingSupportFragmentInjector: DispatchingAndroidInjector<android.support.v4.app.Fragment>


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

    override fun fragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingFragmentInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<android.support.v4.app.Fragment> {
        return dispatchingSupportFragmentInjector
    }
}
package com.example.anhptt.firststepmvvm.common.di.scopes

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass


@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)